package com.terranullius.tamshaemployees.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.terranullius.tamshaemployees.features.employee_list.data.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employees")
    fun getAllEmployees(): Flow<List<Employee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(restaurants: List<Employee>)

    @Query("DELETE FROM employees")
    suspend fun deleteAllEmployees()
}