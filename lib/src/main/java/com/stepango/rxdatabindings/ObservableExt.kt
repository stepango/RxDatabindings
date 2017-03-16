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

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Int>.setTo(field: ObservableInt): Observable<Int> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Byte>.setTo(field: ObservableByte): Observable<Byte> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Char>.setTo(field: ObservableChar): Observable<Char> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Long>.setTo(field: ObservableLong): Observable<Long> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Short>.setTo(field: ObservableShort): Observable<Short> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Float>.setTo(field: ObservableFloat): Observable<Float> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Double>.setTo(field: ObservableDouble): Observable<Double> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun Observable<Boolean>.setTo(field: ObservableBoolean): Observable<Boolean> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Any> Observable<T>.setTo(field: ObservableField<in T>): Observable<T> = doOnNext { field.set(it) }

/**
 * Set value to field with corresponding type
 * @param field observable value holder
 */
fun <T : Parcelable> Observable<T>.setTo(field: ObservableParcelable<in T>): Observable<T> = doOnNext { field.set(it) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any> Observable<T>.setTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Any> Observable<T>.setTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Set transformed value to field with corresponding type
 * @param field observable value holder
 * @param transformer value transformer
 */
inline fun <T : Any, R : Parcelable> Observable<T>.setTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R
): Observable<T> = doOnNext { field.set(transformer(it)) }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableInt,
        crossinline transformer: (T) -> Int?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableByte,
        crossinline transformer: (T) -> Byte?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableChar,
        crossinline transformer: (T) -> Char?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableLong,
        crossinline transformer: (T) -> Long?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableShort,
        crossinline transformer: (T) -> Short?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableFloat,
        crossinline transformer: (T) -> Float?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableDouble,
        crossinline transformer: (T) -> Double?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any> Observable<T>.safeSetTo(
        field: ObservableBoolean,
        crossinline transformer: (T) -> Boolean?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Any> Observable<T>.safeSetTo(
        field: ObservableField<in R>,
        crossinline transformer: (T) -> R?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }

/**
 * Safe variant of @see [setTo] method that accepts and
 * skip null values emitted by transformer
 */
inline fun <T : Any, R : Parcelable> Observable<T>.safeSetTo(
        field: ObservableParcelable<in R>,
        crossinline transformer: (T) -> R?
): Observable<T> = doOnNext { transformer(it)?.let { field.set(it) } }
