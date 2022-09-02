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


fun getDummyEmployees(): List<Employee> = listOf(
    Employee("1", "John", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("2", "Jane", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("3", "Jack", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("4", "Jill", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("5", "Jenny", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("6", "Jen", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("7", "Jenny", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("8", "Jen", 25, 100000, "https://randomuser.me/api/portraits"),
    Employee("9", "Jenny", 25, 100000, "https://randomuser.me/api/portraits")
)