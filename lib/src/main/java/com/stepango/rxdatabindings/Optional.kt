package com.stepango.rxdatabindings

import java.util.NoSuchElementException

/**
 * This class mimic [java.util.Optional] class api full docs could be found here
 * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 */
sealed class Optional<T : Any>(protected val value: T? = null) {

    fun get(): T {
        value ?: throw NoSuchElementException("No value present")
        return value
    }

    val isPresent: Boolean
        get() = value != null

    inline fun ifPresent(consumer: (T) -> Unit) = apply { value?.let { consumer(value) } }

    inline fun filter(predicate: (T) -> Boolean): Optional<T>
            = value?.let { if (predicate(it)) this else empty<T>() } ?: this

    inline fun <U : Any> map(mapper: (T) -> U): Optional<U>
            = value?.let { Optional.ofNullable(mapper(it)) } ?: empty<U>()

    inline fun <U : Any> flatMap(mapper: (T) -> Optional<U>): Optional<U>
            = value?.let { mapper(it) } ?: empty<U>()

    fun orElse(other: T): T = value ?: other

    fun orElseGet(other: () -> T): T = value ?: other()

    inline fun <X : Throwable> orElseThrow(exceptionSupplier: () -> X): T
            = value ?: throw exceptionSupplier()

    override fun equals(other: Any?): Boolean = when {
        this === other        -> true
        other !is Optional<*> -> false
        else                  -> value == other.value
    }

    override fun toString(): String = value?.let { "Optional[$value]" } ?: "Optional.EMPTY"

    override fun hashCode(): Int = value?.hashCode() ?: 0

    object EMPTY : Optional<Nothing>()

    class Some<T : Any>(value: T) : Optional<T>(value)

    companion object {

        @Suppress("UNCHECKED_CAST") fun <T : Any> empty(): Optional<T> = EMPTY as Optional<T>

        fun <T : Any> of(value: T): Optional<T> = Some(value)

        fun <T : Any> ofNullable(value: T?): Optional<T> = value?.let { of(it) } ?: empty<T>()
    }

}

fun <T : Any> T?.toOptional() = Optional.ofNullable(this)

fun <T : Any> Optional<T>.orNull(): T? = if (isPresent) get() else null