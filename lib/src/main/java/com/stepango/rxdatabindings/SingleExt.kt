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
import io.reactivex.rxjava3.core.Single


/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Int>.setTo(field: ObservableInt): Single<Int> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Byte>.setTo(field: ObservableByte): Single<Byte> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Char>.setTo(field: ObservableChar): Single<Char> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Long>.setTo(field: ObservableLong): Single<Long> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Short>.setTo(field: ObservableShort): Single<Short> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Float>.setTo(field: ObservableFloat): Single<Float> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Double>.setTo(field: ObservableDouble): Single<Double> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Single<Boolean>.setTo(field: ObservableBoolean): Single<Boolean> = doOnSuccess(field::set)

fun Single<String>.setTo(field: ObservableString): Single<String> = doOnSuccess(field::set)

fun Single<Spanned>.setTo(field: ObservableSpanned): Single<Spanned> = doOnSuccess(field::set)

fun Single<Number>.setTo(field: ObservableNumber): Single<Number> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Any> Single<T>.setTo(field: ObservableField<in T>): Single<T> = doOnSuccess(field::set)

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Parcelable> Single<T>.setTo(field: ObservableParcelable<in T>): Single<T> = doOnSuccess(field::set)

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Single<T>.setTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean
): Single<T> = doOnSuccess { field.set(transformer(it)) }

inline fun <T : Any> Single<T>.setTo(
        field: ObservableString,
        crossinline transformer: (T) -> String
): Single<T> = doOnSuccess { field.set(transformer(it)) }

inline fun <T : Any> Single<T>.setTo(
        field: ObservableSpanned,
        crossinline transformer: (T) -> Spanned
): Single<T> = doOnSuccess { field.set(transformer(it)) }

inline fun <T : Any> Single<T>.setTo(
        field: ObservableNumber,
        crossinline transformer: (T) -> Number
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Any> Single<T>.setTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Parcelable> Single<T>.setTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R
): Single<T> = doOnSuccess { field.set(transformer(it)) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableString,
        crossinline transformer: (T) -> String?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableSpanned,
        crossinline transformer: (T) -> Spanned?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

inline fun <T : Any> Single<T>.safeSetTo(
        field: ObservableNumber,
        crossinline transformer: (T) -> Number?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Any> Single<T>.safeSetTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Parcelable> Single<T>.safeSetTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R?
): Single<T> = doOnSuccess { tValue -> transformer(tValue)?.let(field::set) }
