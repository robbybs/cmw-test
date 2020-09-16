package com.rbs.cmwtest.models

import com.google.gson.annotations.SerializedName

data class DeleteEmployeeResponse(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val data: String? = null,

    @field:SerializedName("message")
    val message: String? = null
)