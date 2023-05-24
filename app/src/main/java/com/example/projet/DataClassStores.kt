package com.example.projet

import android.os.Parcel
import android.os.Parcelable

data class DataClassStores(var dataStoreImage:Int, var dataStoreTitle:String,var dataPhone:String,
    var dataCall: String,var dataLocation: String,var dataMail: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataStoreImage)
        parcel.writeString(dataStoreTitle)
        parcel.writeString(dataPhone)
        parcel.writeString(dataCall)
        parcel.writeString(dataLocation)
        parcel.writeString(dataMail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClassStores> {
        override fun createFromParcel(parcel: Parcel): DataClassStores {
            return DataClassStores(parcel)
        }

        override fun newArray(size: Int): Array<DataClassStores?> {
            return arrayOfNulls(size)
        }
    }
}
