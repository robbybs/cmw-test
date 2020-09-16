package com.rbs.cmwtest.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Employee(
    @field:SerializedName("id")
    val employeeId: String? = null,

    @field:SerializedName("employee_name")
    val employeeName: String? = null,

    @field:SerializedName("employee_salary")
    val employeeSalary: String? = null,

    @field:SerializedName("employee_age")
    val employeeAge: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(employeeId)
        parcel.writeString(employeeName)
        parcel.writeString(employeeSalary)
        parcel.writeString(employeeAge)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}