@file:OptIn(ExperimentalFoundationApi::class)

package com.terranullius.tamshaemployees.features.employee_list

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.terranullius.tamshaemployees.compose.components.getTranslationXAnim
import com.terranullius.tamshaemployees.compose.theme.TamashaApp
import com.terranullius.tamshaemployees.features.employee_list.data.Employee
import com.terranullius.tamshaemployees.features.employee_list.data.getDummyEmployees
import com.terranullius.tamshaemployees.util.Result

@Composable
fun EmployeeScreen(modifier: Modifier = Modifier, viewModel: EmployeeViewModel = viewModel()) {
    val employeeListResult = viewModel.employees.collectAsState().value
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        EmployeeScreenContent(
            modifier = Modifier.fillMaxSize(),
            employees = employeeListResult.data,
            isLoading = employeeListResult is Result.Loading,
            errorMsg = (employeeListResult as? Result.Error)?.errorMessage
        )
    }
}

@Composable
private fun EmployeeScreenContent(
    modifier: Modifier = Modifier,
    employees: List<Employee>?,
    isLoading: Boolean = false,
    errorMsg: String? = null
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        if (isLoading) item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (errorMsg != null) item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = errorMsg, style = MaterialTheme.typography.h6)
            }
        }
        if (employees != null) itemsIndexed(
            employees,
            key = { _, employee -> employee.id }) { index, employee ->
            val translation = getTranslationXAnim(index = index)
            EmployeeItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationX = translation.value
                    },
                employee = employee
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EmployeeScreenContentPrev() {
    TamashaApp {
        EmployeeScreenContent(
            employees = getDummyEmployees(),
            modifier = Modifier.fillMaxSize(),
            isLoading = true
        )
    }
}


