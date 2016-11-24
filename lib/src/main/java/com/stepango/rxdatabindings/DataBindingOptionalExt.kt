package com.stepango.rxdatabindings

import android.databinding.ObservableField
import android.databinding.ObservableParcelable
import android.os.Parcelable
import com.stepango.koptional.toOptional

fun <T : Any> ObservableField<T?>.observeOption() = observe { it.get().toOptional() }
fun <T : Parcelable> ObservableParcelable<T?>.observeOption() = observe { it.get().toOptional() }
