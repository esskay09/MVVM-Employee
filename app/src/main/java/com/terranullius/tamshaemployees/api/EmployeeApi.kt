package com.terranullius.tamshaemployees.api

import com.terranullius.tamshaemployees.api.models.EmployeeListDto
import retrofit2.http.GET

interface EmployeeApi {
    companion object {
        const val BASE_URL = "https://mocki.io/v1/"
    }

    @GET("61cf7d91-a7f8-405e-b505-67926b759d78")
    suspend fun getEmployeeList(): EmployeeListDto


}