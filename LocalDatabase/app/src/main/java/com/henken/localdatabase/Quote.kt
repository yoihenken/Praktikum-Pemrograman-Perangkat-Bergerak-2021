package com.henken.localdatabase

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quote(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var category: String? = null,
    var date: String? = null
) : Parcelable
