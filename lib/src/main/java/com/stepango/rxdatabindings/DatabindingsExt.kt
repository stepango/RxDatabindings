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
import io.reactivex.Observable.create
import io.reactivex.Scheduler
import androidx.databinding.Observable as DataBindingObservable

@Suppress("UNCHECKED_CAST")
internal inline fun <T : DataBindingObservable, R : Any?> T.observe(
        scheduler: Scheduler,
        fireInitialValue: Boolean,
        crossinline transformer: (T) -> R
): Observable<R> = create<R> { source ->

    if (fireInitialValue && !source.isDisposed) try {
        source.onNext(transformer(this))
    } catch (e: Exception) {
        source.onError(e)
        return@create
    }

    object : DataBindingObservable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: DataBindingObservable, id: Int) = if (!source.isDisposed) try {
            source.onNext(transformer(observable as T))
        } catch (e: Exception) {
            source.onError(e)
        } else Unit
    }.let {
        source.setCancellable { removeOnPropertyChangedCallback(it) }
        addOnPropertyChangedCallback(it)
    }

}.subscribeOn(scheduler)

fun ObservableInt.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableByte.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableChar.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableLong.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableShort.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableFloat.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableDouble.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun ObservableBoolean.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun <T : Any> ObservableField<T>.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }

fun <T : Parcelable> ObservableParcelable<T>.observe(scheduler: Scheduler = dataBindingsScheduler, fireInitialValue: Boolean = true) =
        observe(scheduler, fireInitialValue) { it.get() }
