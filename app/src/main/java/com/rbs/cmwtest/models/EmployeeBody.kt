package com.rbs.cmwtest.models

import com.google.gson.annotations.SerializedName

data class EmployeeBody(
    @field:SerializedName("name")
    val employeeName: String? = null,

    @field:SerializedName("salary")
    val employeeSalary: String? = null,

    @field:SerializedName("age")
    val employeeAge: String? = null
)