package com.terranullius.tamshaemployees.features.employee_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val age: Int,
    val salary: Long,
    val profilePic: String?
)
