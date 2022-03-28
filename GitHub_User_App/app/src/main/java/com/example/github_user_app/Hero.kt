package com.example.github_user_app

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name: String?,
    var user: String?,
    var photo: Int?,
    var perusahaan: String?,
    var lokasi: String?,
    var pengikut: Int?,
    var mengikuti: Int?,
    var repositori: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),

    )

    override fun describeContents(): Int {
        return 0
    }

    /**companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }**/

        /**override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }**/
    }
