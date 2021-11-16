package com.alamin.navigationcomponents_kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Money (val  name : String,val amount: String):Parcelable{}