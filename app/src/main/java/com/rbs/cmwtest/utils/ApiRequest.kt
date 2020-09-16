package com.rbs.cmwtest.utils

import com.rbs.cmwtest.models.CreateEmployeeResponse
import com.rbs.cmwtest.models.DeleteEmployeeResponse
import com.rbs.cmwtest.models.EmployeeBody
import com.rbs.cmwtest.models.EmployeeResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiRequest {
    @GET("employees")
    fun getEmployees(): Call<EmployeeResponse>

    @POST("create")
    fun createEmployee(@Body employeeBody: EmployeeBody): Call<CreateEmployeeResponse>

    @DELETE("delete/{id}")
    fun deleteEmployee(@Path("id") employeeId: String): Call<DeleteEmployeeResponse>

    @PUT("update/{id}")
    fun updateEmployee(@Body employeeBody: EmployeeBody, @Path("id") employeeId: String): Call<CreateEmployeeResponse>
}