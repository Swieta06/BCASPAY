package com.example.bcaspay.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListModel(
    val image:Int?,
    val title:String?,
    val subtitle:String?
): Parcelable