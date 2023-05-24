package com.example.projet

import android.os.Parcel
import android.os.Parcelable

data class DataClassDiets(var dataImage:Int, var dataTitle:String ,var dataDes: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClassDiets> {
        override fun createFromParcel(parcel: Parcel): DataClassDiets {
            return DataClassDiets(parcel)
        }

        override fun newArray(size: Int): Array<DataClassDiets?> {
            return arrayOfNulls(size)
        }
    }
}
