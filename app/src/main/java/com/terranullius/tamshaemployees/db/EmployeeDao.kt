package com.terranullius.tamshaemployees.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee_table")
    fun getAllEmployees(): List<EmployeeEntity>
}