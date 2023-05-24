package com.example.projet

import android.os.Parcel
import android.os.Parcelable

data class DataClassDocAccount(
    var dataImage:Int, var dataTitle:String, var dataTitle2: String,
     var dataPhone:String, var dataCall: String,var dataLocation: String,
    var dataMail: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataTitle2)
        parcel.writeString(dataPhone)
        parcel.writeString(dataCall)
        parcel.writeString(dataLocation)
        parcel.writeString(dataMail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClassDocAccount> {
        override fun createFromParcel(parcel: Parcel): DataClassDocAccount {
            return DataClassDocAccount(parcel)
        }

        override fun newArray(size: Int): Array<DataClassDocAccount?> {
            return arrayOfNulls(size)
        }
    }
}
