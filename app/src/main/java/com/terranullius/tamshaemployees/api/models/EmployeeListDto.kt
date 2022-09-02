package com.terranullius.tamshaemployees.api.models


import com.google.gson.annotations.SerializedName
import com.terranullius.tamshaemployees.db.EmployeeEntity

data class EmployeeListDto(
    @SerializedName("data")
    val data: List<EmployeeDto> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: String = ""
) {
    fun toEmployeeEntityList() = data.map {
        it.toEmployeeEntity()
    }
}

data class EmployeeDto(
    @SerializedName("employee_age")
    val employeeAge: Int = 0,
    @SerializedName("employee_name")
    val employeeName: String = "",
    @SerializedName("employee_salary")
    val employeeSalary: Long = 0L,
    @SerializedName("id")
    val id: String,
    @SerializedName("profile_image")
    val profileImage: String? = null
) {
    fun toEmployeeEntity() = EmployeeEntity(
        age = employeeAge,
        name = employeeName,
        salary = employeeSalary,
        id = id,
        profilePic = profileImage
    )
}