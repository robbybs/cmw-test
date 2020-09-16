package com.rbs.cmwtest.ui.employee

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rbs.cmwtest.R
import com.rbs.cmwtest.models.Employee
import kotlinx.android.synthetic.main.item_employee.view.*

class EmployeeAdapter(private val listEmployee: List<Employee?>?, private val context: Context) :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listEmployee?.size!!

    override fun onBindViewHolder(holder: EmployeeAdapter.ViewHolder, position: Int) {
        listEmployee?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(listEmployee: Employee) {
            with(itemView) {
                tv_id.text = "ID: ${listEmployee.employeeId}"
                tv_name.text = "Name: ${listEmployee.employeeName}"
                tv_salary.text = "Salary: ${listEmployee.employeeSalary}"
                tv_age.text = "Age: ${listEmployee.employeeAge}"

                btn_edit.setOnClickListener {
                    onItemClickCallback.editData(listEmployee)
                }

                btn_delete.setOnClickListener {
                    onItemClickCallback.deleteData(listEmployee)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun editData(data: Employee)
        fun deleteData(data: Employee)
    }
}