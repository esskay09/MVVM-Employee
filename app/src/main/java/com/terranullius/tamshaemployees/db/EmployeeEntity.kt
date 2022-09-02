package com.terranullius.tamshaemployees.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val age: String,
    val salary: Long,
    val profilePic: String
)
