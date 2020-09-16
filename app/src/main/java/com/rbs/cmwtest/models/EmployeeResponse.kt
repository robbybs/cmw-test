package com.rbs.cmwtest.models

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val data: List<Employee?>? = null
)