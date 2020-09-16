package com.rbs.cmwtest.ui.employee

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rbs.cmwtest.R
import com.rbs.cmwtest.models.Employee
import com.rbs.cmwtest.ui.MainActivity
import com.rbs.cmwtest.utils.RetrofitRequest
import kotlinx.android.synthetic.main.activity_employee.*

class EmployeeActivity : AppCompatActivity(), EmployeeView {
    private lateinit var presenter: EmployeePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        initializePresenter()
    }

    override fun initializePresenter() {
        presenter = EmployeePresenter()
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

    override fun setData(data: List<Employee?>?) {
        rv_employee.setHasFixedSize(true)
        rv_employee.layoutManager = LinearLayoutManager(this)
        rv_employee.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        val adapter = EmployeeAdapter(data, this)
        rv_employee.adapter = adapter

        adapter.setOnItemClickCallback(object : EmployeeAdapter.OnItemClickCallback {
            override fun editData(data: Employee) {

            }

            override fun deleteData(data: Employee) {
                presenter.deleteEmployee(data.employeeId.toString())
            }
        })
    }

    override fun setSuccessMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }
}