package com.example.bcaspay.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NewsModel(
    val image:Int?,
    val title:String?,
    val subtitle:String?,
    val icon:Int?
):Parcelable