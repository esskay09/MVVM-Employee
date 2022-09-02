package com.terranullius.tamshaemployees.features.employee_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terranullius.tamshaemployees.features.employee_list.data.EmployeeRepository
import com.terranullius.tamshaemployees.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    repository: EmployeeRepository
) : ViewModel() {
    val employees = repository.getEmployees().stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000L),
        initialValue = Result.Loading()
    )
}