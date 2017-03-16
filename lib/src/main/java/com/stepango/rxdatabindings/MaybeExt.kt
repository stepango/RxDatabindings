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
import io.reactivex.Maybe

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Int>.setTo(field: ObservableInt): Maybe<Int> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Byte>.setTo(field: ObservableByte): Maybe<Byte> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Char>.setTo(field: ObservableChar): Maybe<Char> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Long>.setTo(field: ObservableLong): Maybe<Long> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Short>.setTo(field: ObservableShort): Maybe<Short> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Float>.setTo(field: ObservableFloat): Maybe<Float> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Double>.setTo(field: ObservableDouble): Maybe<Double> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Maybe<Boolean>.setTo(field: ObservableBoolean): Maybe<Boolean> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Any> Maybe<T>.setTo(field: ObservableField<in T>): Maybe<T> = doOnSuccess { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Parcelable> Maybe<T>.setTo(field: ObservableParcelable<in T>): Maybe<T> = doOnSuccess { field.set(it) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Maybe<T>.setTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Any> Maybe<T>.setTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Parcelable> Maybe<T>.setTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R
): Maybe<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Maybe<T>.safeSetTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Any> Maybe<T>.safeSetTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Parcelable> Maybe<T>.safeSetTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R?
): Maybe<T> = doOnSuccess { transformer(it)?.let { field.set(it) } }
