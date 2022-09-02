package com.terranullius.tamshaemployees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.terranullius.tamshaemployees.features.employee_list.EmployeeScreen
import com.terranullius.tamshaemployees.compose.theme.TamashaApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TamashaApp {
                EmployeeScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
