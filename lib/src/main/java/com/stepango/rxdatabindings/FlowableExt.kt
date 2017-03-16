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
import io.reactivex.Flowable

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Int>.setTo(field: ObservableInt): Flowable<Int> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Byte>.setTo(field: ObservableByte): Flowable<Byte> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Char>.setTo(field: ObservableChar): Flowable<Char> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Long>.setTo(field: ObservableLong): Flowable<Long> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Short>.setTo(field: ObservableShort): Flowable<Short> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Float>.setTo(field: ObservableFloat): Flowable<Float> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Double>.setTo(field: ObservableDouble): Flowable<Double> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Flowable<Boolean>.setTo(field: ObservableBoolean): Flowable<Boolean> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Any> Flowable<T>.setTo(field: ObservableField<in T>): Flowable<T> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Parcelable> Flowable<T>.setTo(field: ObservableParcelable<in T>): Flowable<T> = doOnNext { field.set(it) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Flowable<T>.setTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Any> Flowable<T>.setTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Parcelable> Flowable<T>.setTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R
): Flowable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Flowable<T>.safeSetTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Any> Flowable<T>.safeSetTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Parcelable> Flowable<T>.safeSetTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R?
): Flowable<T> = doOnNext { transformer(it)?.let { field.set(it) } }
