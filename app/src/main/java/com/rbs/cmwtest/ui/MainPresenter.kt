package com.rbs.cmwtest.ui

import com.rbs.cmwtest.base.BasePresenter
import com.rbs.cmwtest.models.CreateEmployeeResponse
import com.rbs.cmwtest.models.Employee
import com.rbs.cmwtest.models.EmployeeBody
import com.rbs.cmwtest.utils.ApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : BasePresenter<MainView>() {
    private lateinit var service: ApiRequest

    fun initialization() {
        if (isViewAttached()) getView()?.setService()
    }

    fun setService(service: ApiRequest) {
        this.service = service
    }

    fun createEmployee(name: String, salary: String, age: String) {
        val employeeBody =
            EmployeeBody(employeeName = name, employeeSalary = salary, employeeAge = age)
        sendDataEmployee(employeeBody)
    }

    private fun createNewEmployee(employeeBody: EmployeeBody) = service.createEmployee(employeeBody)

    private fun sendDataEmployee(employeeBody: EmployeeBody) {
        createNewEmployee(employeeBody).enqueue(object : Callback<CreateEmployeeResponse> {
            override fun onFailure(call: Call<CreateEmployeeResponse>, t: Throwable) {
                if (isViewAttached()) getView()?.setErrorMessage(t.message.toString())
            }

            override fun onResponse(
                call: Call<CreateEmployeeResponse>,
                response: Response<CreateEmployeeResponse>
            ) {
                if (response.body() != null) {
                    if (isViewAttached()) getView()?.setSuccessMessage(response.body()!!.status.toString())
                }
            }
        })
    }

    fun updateEmployee(data: Employee) {
        val body = EmployeeBody(
            employeeName = data.employeeName,
            employeeSalary = data.employeeSalary,
            employeeAge = data.employeeAge
        )
        updateDataEmployee(body, data.employeeId.toString())
    }

    fun updateData(
        body: EmployeeBody,
        employeeId: String
    ) = service.updateEmployee(body, employeeId)

    fun updateDataEmployee(body: EmployeeBody, id: String) {
        updateData(body, id).enqueue(object : Callback<CreateEmployeeResponse> {
            override fun onFailure(call: Call<CreateEmployeeResponse>, t: Throwable) {
                if (isViewAttached()) getView()?.setErrorMessage(t.message.toString())
            }

            override fun onResponse(
                call: Call<CreateEmployeeResponse>,
                response: Response<CreateEmployeeResponse>
            ) {
                if (response.body() != null) {
                    if (isViewAttached()) getView()?.setSuccessMessage(response.body()!!.message.toString())
                }
            }
        })
    }
}