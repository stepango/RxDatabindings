/**
 * Copyright 2016 Goncharov Stepan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stepango.rxdatabindings

import android.databinding.ObservableBoolean
import android.databinding.ObservableByte
import android.databinding.ObservableChar
import android.databinding.ObservableDouble
import android.databinding.ObservableField
import android.databinding.ObservableFloat
import android.databinding.ObservableInt
import android.databinding.ObservableLong
import android.databinding.ObservableParcelable
import android.databinding.ObservableShort
import android.os.Parcelable
import io.reactivex.Observable
import io.reactivex.Observable.create
import java.lang.Math.max
import java.lang.Math.min
import android.databinding.Observable as DataBindingObservable

@Suppress("UNCHECKED_CAST")
inline fun <T : DataBindingObservable, R : Any?> T.observe(
        crossinline block: (T) -> R
): Observable<R> = create { subscriber ->
    object : DataBindingObservable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: DataBindingObservable, id: Int) = try {
            subscriber.onNext(block(observable as T))
        } catch (e: Exception) {
            subscriber.onError(e)
        }
    }.let {
        subscriber.setCancellable { removeOnPropertyChangedCallback(it) }
        addOnPropertyChangedCallback(it)
    }
}

/**
 * Observable wrapper for non-nullable String
 */
class ObservableString(initialValue: String) : ObservableField<String>(initialValue)

/**
 * Observable wrapper for number
 */
class ObservableNumber(initialValue: Number) : ObservableField<Number>(initialValue)

fun ObservableInt.set(value: Number) = set(value.toInt())
fun ObservableLong.set(value: Number) = set(value.toLong())

fun Observable<Int>.setTo(field: ObservableInt): Observable<Int> = doOnNext { field.set(it) }
fun Observable<Byte>.setTo(field: ObservableByte): Observable<Byte> = doOnNext { field.set(it) }
fun Observable<Char>.setTo(field: ObservableChar): Observable<Char> = doOnNext { field.set(it) }
fun Observable<Long>.setTo(field: ObservableLong): Observable<Long> = doOnNext { field.set(it) }
fun Observable<Short>.setTo(field: ObservableShort): Observable<Short> = doOnNext { field.set(it) }
fun Observable<Float>.setTo(field: ObservableFloat): Observable<Float> = doOnNext { field.set(it) }
fun Observable<Double>.setTo(field: ObservableDouble): Observable<Double> = doOnNext { field.set(it) }
fun Observable<Boolean>.setTo(field: ObservableBoolean): Observable<Boolean> = doOnNext { field.set(it) }
fun <T : Any> Observable<T>.setTo(field: ObservableField<in T>): Observable<T> = doOnNext { field.set(it) }
fun <T : Parcelable> Observable<T>.setTo(field: ObservableParcelable<in T>): Observable<T> = doOnNext { field.set(it) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableInt, crossinline block: (T) -> Int
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableByte, crossinline block: (T) -> Byte
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableChar, crossinline block: (T) -> Char
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableLong, crossinline block: (T) -> Long
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableShort, crossinline block: (T) -> Short
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableFloat, crossinline block: (T) -> Float
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableDouble, crossinline block: (T) -> Double
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any> Observable<T>.setTo(
        field: ObservableBoolean, crossinline block: (T) -> Boolean
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any, R : Any> Observable<T>.setTo(
        field: ObservableField<in R>, crossinline block: (T) -> R
): Observable<T> = doOnNext { field.set(block(it)) }

inline fun <T : Any, R : Parcelable> Observable<T>.setTo(
        field: ObservableParcelable<in R>, crossinline block: (T) -> R
): Observable<T> = doOnNext { field.set(block(it)) }

fun ObservableInt.observe() = observe { it.get() }
fun ObservableByte.observe() = observe { it.get() }
fun ObservableChar.observe() = observe { it.get() }
fun ObservableLong.observe() = observe { it.get() }
fun ObservableShort.observe() = observe { it.get() }
fun ObservableFloat.observe() = observe { it.get() }
fun ObservableDouble.observe() = observe { it.get() }
fun ObservableBoolean.observe() = observe { it.get() }
fun <T : Any> ObservableField<T>.observe() = observe { it.get() }
fun <T : Parcelable> ObservableParcelable<T>.observe() = observe { it.get() }

operator fun ObservableInt.invoke() = get()
operator fun ObservableByte.invoke() = get()
operator fun ObservableChar.invoke() = get()
operator fun ObservableLong.invoke() = get()
operator fun ObservableShort.invoke() = get()
operator fun ObservableFloat.invoke() = get()
operator fun ObservableDouble.invoke() = get()
operator fun ObservableBoolean.invoke() = get()
operator fun <T : Any?> ObservableField<T>.invoke(): T = get()
operator fun <T : Parcelable?> ObservableParcelable<T>.invoke(): T = get()

fun ObservableInt.inc() = apply { set(get().inc()) }
fun ObservableByte.inc() = apply { set(get().inc()) }
fun ObservableChar.inc() = apply { set(get().inc()) }
fun ObservableLong.inc() = apply { set(get().inc()) }
fun ObservableShort.inc() = apply { set(get().inc()) }
fun ObservableFloat.inc() = apply { set(get().inc()) }
fun ObservableDouble.inc() = apply { set(get().inc()) }

fun ObservableInt.inc(max: Int) = apply { set(min(get().inc(), max)) }
fun ObservableByte.inc(max: Byte) = apply { set(min(get().inc(), max)) }
fun ObservableChar.inc(max: Char) = apply { set(min(get().inc(), max)) }
fun ObservableLong.inc(max: Long) = apply { set(min(get().inc(), max)) }
fun ObservableShort.inc(max: Short) = apply { set(min(get().inc(), max)) }
fun ObservableFloat.inc(max: Float) = apply { set(min(get().inc(), max)) }
fun ObservableDouble.inc(max: Double) = apply { set(min(get().inc(), max)) }

fun ObservableInt.dec() = apply { set(get().dec()) }
fun ObservableByte.dec() = apply { set(get().dec()) }
fun ObservableChar.dec() = apply { set(get().dec()) }
fun ObservableLong.dec() = apply { set(get().dec()) }
fun ObservableShort.dec() = apply { set(get().dec()) }
fun ObservableFloat.dec() = apply { set(get().dec()) }
fun ObservableDouble.dec() = apply { set(get().dec()) }

fun ObservableInt.dec(min: Int) = apply { set(max(get().dec(), min)) }
fun ObservableByte.dec(min: Byte) = apply { set(max(get().dec(), min)) }
fun ObservableChar.dec(min: Char) = apply { set(max(get().dec(), min)) }
fun ObservableLong.dec(min: Long) = apply { set(max(get().dec(), min)) }
fun ObservableShort.dec(min: Short) = apply { set(max(get().dec(), min)) }
fun ObservableFloat.dec(min: Float) = apply { set(max(get().dec(), min)) }
fun ObservableDouble.dec(min: Double) = apply { set(max(get().dec(), min)) }

private fun min(a: Short, b: Short) = if (a > b) b else a
private fun min(a: Byte, b: Byte) = if (a > b) b else a
private fun min(a: Char, b: Char) = if (a > b) b else a

private fun max(a: Short, b: Short) = if (a < b) b else a
private fun max(a: Byte, b: Byte) = if (a < b) b else a
private fun max(a: Char, b: Char) = if (a < b) b else a