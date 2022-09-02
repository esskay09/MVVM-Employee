package com.terranullius.tamshaemployees.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.terranullius.tamshaemployees.features.employee_list.data.Employee

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao
}