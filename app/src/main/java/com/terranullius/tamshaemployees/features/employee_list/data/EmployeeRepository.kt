package com.terranullius.tamshaemployees.features.employee_list.data

import androidx.room.withTransaction
import com.terranullius.tamshaemployees.api.EmployeeApi
import com.terranullius.tamshaemployees.db.EmployeeDatabase
import com.terranullius.tamshaemployees.util.networkBoundResource
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val api: EmployeeApi,
    private val db: EmployeeDatabase
) {
    private val employeeDao = db.employeeDao()

    fun getEmployees() = networkBoundResource(
        query = {
            employeeDao.getAllEmployees()
        },
        fetch = {
            api.getEmployees()
        },
        saveFetchResult = { employees ->
            db.withTransaction {
                employeeDao.deleteAllEmployees()
                employeeDao.insertEmployees(employees.toEmployeeList())
            }
        }
    )
}