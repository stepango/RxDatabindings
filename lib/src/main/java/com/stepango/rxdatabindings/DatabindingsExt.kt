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
import io.reactivex.Scheduler
import java.lang.Math.max
import java.lang.Math.min
import android.databinding.Observable as DataBindingObservable

@Suppress("UNCHECKED_CAST")
inline fun <T : DataBindingObservable, R : Any?> T.observe(
        scheduler: Scheduler,
        fireInitialValue: Boolean,
        crossinline transformer: (T) -> R
): Observable<R> = create<R> { source ->

    if (fireInitialValue) try {
        source.onNext(transformer(this))
    } catch (e: Exception) {
        source.onError(e)
        return@create
    }

    object : DataBindingObservable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: DataBindingObservable, id: Int) = try {
            source.onNext(transformer(observable as T))
        } catch (e: Exception) {
            source.onError(e)
        }
    }.apply {
        source.setCancellable { removeOnPropertyChangedCallback(this) }
        addOnPropertyChangedCallback(this)
    }

}.observeOn(scheduler)

fun ObservableInt.set(value: Number) = set(value.toInt())
fun ObservableLong.set(value: Number) = set(value.toLong())

fun ObservableInt.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableByte.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableChar.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableLong.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableShort.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableFloat.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableDouble.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun ObservableBoolean.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun <T : Any> ObservableField<T>.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

fun <T : Parcelable> ObservableParcelable<T>.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true)
        = observe(scheduler, fireInitialValue) { it.get() }

@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableInt.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableByte.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableChar.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableLong.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableShort.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableFloat.inc() = apply { set(get().inc()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().inc()) }"))
fun ObservableDouble.inc() = apply { set(get().inc()) }

@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableInt.inc(max: Int) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableByte.inc(max: Byte) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableChar.inc(max: Char) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableLong.inc(max: Long) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableShort.inc(max: Short) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableFloat.inc(max: Float) = apply { set(min(get().inc(), max)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(min(get().inc(), max)) }", "java.lang.Math.min"))
fun ObservableDouble.inc(max: Double) = apply { set(min(get().inc(), max)) }

@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableInt.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableByte.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableChar.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableLong.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableShort.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableFloat.dec() = apply { set(get().dec()) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(get().dec()) }"))
fun ObservableDouble.dec() = apply { set(get().dec()) }

@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableInt.dec(min: Int) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableByte.dec(min: Byte) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableChar.dec(min: Char) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableLong.dec(min: Long) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableShort.dec(min: Short) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableFloat.dec(min: Float) = apply { set(max(get().dec(), min)) }
@Deprecated("Would be removed in 1.3", ReplaceWith("apply { set(max(get().dec(), min)) }", "java.lang.Math.max"))
fun ObservableDouble.dec(min: Double) = apply { set(max(get().dec(), min)) }
