package com.rbs.cmwtest.ui.employee

import com.rbs.cmwtest.base.View
import com.rbs.cmwtest.models.Employee

interface EmployeeView : View {
    fun setData(data: List<Employee?>?)

    fun setSuccessMessage(message: String)
}