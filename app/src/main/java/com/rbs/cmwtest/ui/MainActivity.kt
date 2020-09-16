package com.rbs.cmwtest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rbs.cmwtest.R
import com.rbs.cmwtest.models.Employee
import com.rbs.cmwtest.ui.employee.EmployeeActivity
import com.rbs.cmwtest.utils.RetrofitRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializePresenter()
        getNewEmployee()
        goToListEmployee()
    }

    override fun initializePresenter() {
        presenter = MainPresenter()
        presenter.attachView(this)
        presenter.initialization()
    }

    override fun setService() {
        val service = RetrofitRequest.getService()
        presenter.setService(service)
    }

    override fun setErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setSuccessMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun getNewEmployee() {
        btn_submit.setOnClickListener {
            val name = et_name.text.toString()
            val salary = et_salary.text.toString()
            val age = et_age.text.toString()
            presenter.createEmployee(name, salary, age)
        }
    }

    private fun goToListEmployee() {
        btn_listEmployee.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    EmployeeActivity::class.java
                )
            )
        }
    }

    private fun updateEmployee(data: Employee) {
        presenter.updateEmployee(data)
    }
}