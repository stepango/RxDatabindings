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

import android.databinding.ObservableField
import android.os.Parcel
import android.os.Parcelable


/**
 * Observable wrapper for non-nullable String that implements Parcelable contract
 */
class ObservableString(value: String = "") : ObservableField<String>(value), Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = dest.writeString(get())

    override fun get(): String = super.get() ?: throw IllegalStateException()

    @Suppress("RedundantOverride")
    override fun set(value: String) = super.set(value)

    companion object CREATOR : Parcelable.Creator<ObservableString> {

        override fun createFromParcel(source: Parcel) = ObservableString(source.readString() ?: "")

        override fun newArray(size: Int): Array<ObservableString?> = arrayOfNulls(size)
    }

}
