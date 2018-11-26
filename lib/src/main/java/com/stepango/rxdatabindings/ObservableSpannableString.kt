package com.stepango.rxdatabindings

import android.databinding.ObservableField
import android.os.Parcel
import android.os.Parcelable
import android.text.SpannableString
import android.text.TextUtils


/**
 * Observable wrapper for non-nullable SpannableString that implements Parcelable contract
 */
class ObservableSpannableString(
        value: SpannableString = SpannableString("")
) :
        ObservableField<SpannableString>(value),
        Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = TextUtils.writeToParcel(get(), dest, flags)

    override fun get(): SpannableString = super.get() ?: throw IllegalStateException()

    @Suppress("RedundantOverride")
    override fun set(value: SpannableString) = super.set(value)

    companion object {
        internal const val serialVersionUID = 1L

        @JvmField
        val CREATOR: Parcelable.Creator<ObservableSpannableString> = object : Parcelable.Creator<ObservableSpannableString> {

            override fun createFromParcel(source: Parcel) = ObservableSpannableString(
                    TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source) as SpannableString
            )

            override fun newArray(size: Int): Array<ObservableSpannableString?> = arrayOfNulls(size)
        }
    }
}
