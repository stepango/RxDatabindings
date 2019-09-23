/**
 * Copyright 2017 Goncharov Stepan
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

import android.os.Parcelable
import android.text.Spanned
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableByte
import androidx.databinding.ObservableChar
import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableLong
import androidx.databinding.ObservableParcelable
import androidx.databinding.ObservableShort
import io.reactivex.Observable
import io.reactivex.Scheduler
import androidx.databinding.Observable as DataBindingObservable


internal inline fun <T : DataBindingObservable, R : Any> T.observe(
    scheduler: Scheduler?,
    fireInitialValue: Boolean,
    crossinline transformer: (T) -> R?
): Observable<R> = Observable.create<R> { source ->

    if (fireInitialValue && !source.isDisposed) try {
        transformer(this)?.let(source::onNext)
    } catch (throwable: Throwable) {
        source.onError(throwable)
        return@create
    }

    object : DataBindingObservable.OnPropertyChangedCallback() {
        @Suppress("UNCHECKED_CAST")
        override fun onPropertyChanged(observable: DataBindingObservable, id: Int) = if (!source.isDisposed) try {
            transformer(observable as T)?.let(source::onNext) ?: Unit
        } catch (throwable: Throwable) {
            source.onError(throwable)
        } else Unit
    }.let {
        source.setCancellable { removeOnPropertyChangedCallback(it) }
        addOnPropertyChangedCallback(it)
    }

}.let { if (scheduler != null) it.subscribeOn(scheduler) else it }

fun ObservableBoolean.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Boolean> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableByte.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Byte> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableShort.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Short> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableInt.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Int> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableLong.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Long> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableFloat.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Float> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableDouble.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Double> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableNumber.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Number> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableChar.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Char> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableString.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<String> =
    observe(scheduler, fireInitialValue) { it.get() }

fun ObservableSpanned.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<Spanned> =
    observe(scheduler, fireInitialValue) { it.get() }

fun <T : Any> ObservableField<T>.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<T> = observe(scheduler, fireInitialValue) { it.get() }

fun <T : Parcelable> ObservableParcelable<T>.observe(
    scheduler: Scheduler? = rxDataBindingsScheduler,
    fireInitialValue: Boolean = true
): Observable<T> = observe(scheduler, fireInitialValue) { it.get() }
