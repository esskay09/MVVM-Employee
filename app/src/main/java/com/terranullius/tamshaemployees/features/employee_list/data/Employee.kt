package com.terranullius.tamshaemployees.features.employee_list.data

import java.util.*

data class Employee(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val age: Int,
    val salary: Long,
    val profilePic: String?
)
