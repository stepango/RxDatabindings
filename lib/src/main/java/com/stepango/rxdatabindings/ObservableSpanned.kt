package com.stepango.rxdatabindings

import android.databinding.ObservableField
import android.os.Parcel
import android.os.Parcelable
import android.text.Spanned
import android.text.SpannedString
import android.text.TextUtils


/**
 * Observable wrapper for non-nullable Spanned that implements Parcelable contract
 */
class ObservableSpanned(
        value: Spanned = SpannedString("")
) :
        ObservableField<Spanned>(value),
        Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = TextUtils.writeToParcel(get(), dest, flags)

    override fun get(): Spanned = super.get() ?: throw IllegalStateException()

    @Suppress("RedundantOverride")
    override fun set(value: Spanned) = super.set(value)

    companion object CREATOR : Parcelable.Creator<ObservableSpanned> {

        override fun createFromParcel(source: Parcel) = ObservableSpanned(
                TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source) as Spanned
        )

        override fun newArray(size: Int): Array<ObservableSpanned?> = arrayOfNulls(size)
    }

}
