package com.rbs.cmwtest.ui.employee

import com.rbs.cmwtest.base.BasePresenter
import com.rbs.cmwtest.models.DeleteEmployeeResponse
import com.rbs.cmwtest.models.EmployeeResponse
import com.rbs.cmwtest.utils.ApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeePresenter : BasePresenter<EmployeeView>() {
    private lateinit var service: ApiRequest

    fun initialization() {
        if (isViewAttached()) getView()?.setService()
        getEmployeesData()
    }

    fun setService(service: ApiRequest) {
        this.service = service
    }

    private fun getData() = service.getEmployees()

    private fun getEmployeesData() {
        getData().enqueue(object : Callback<EmployeeResponse> {
            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                if (isViewAttached()) getView()?.setErrorMessage(t.message.toString())
            }

            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                if (response.body() != null) {
                    if (isViewAttached()) getView()?.setData(response.body()!!.data)
                }
            }

        })
    }

    fun deleteEmployee(employeeId: String) {
        deleteDataEmployee(employeeId)
    }

    private fun sendDeleteEmployee(employeeId: String) = service.deleteEmployee(employeeId)

    private fun deleteDataEmployee(employeeId: String) {
        sendDeleteEmployee(employeeId).enqueue(object : Callback<DeleteEmployeeResponse> {
            override fun onFailure(call: Call<DeleteEmployeeResponse>, t: Throwable) {
                if (isViewAttached()) getView()?.setErrorMessage(t.message.toString())
            }

            override fun onResponse(
                call: Call<DeleteEmployeeResponse>,
                response: Response<DeleteEmployeeResponse>
            ) {
                if (response.body() != null) {
                    if (isViewAttached()) getView()?.setSuccessMessage(response.body()?.message.toString())
                }
            }
        })
    }
}