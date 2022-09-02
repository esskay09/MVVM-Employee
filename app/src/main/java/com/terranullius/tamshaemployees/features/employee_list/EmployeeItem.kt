package com.terranullius.tamshaemployees.features.employee_list

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terranullius.tamshaemployees.R
import com.terranullius.tamshaemployees.compose.components.CircularUserImage
import com.terranullius.tamshaemployees.compose.components.listProfileRes
import com.terranullius.tamshaemployees.features.employee_list.data.Employee
import com.terranullius.tamshaemployees.features.employee_list.data.getDummyEmployees


@Composable
fun EmployeeItem(
    modifier: Modifier = Modifier,
    employee: Employee,
) {
    Card(modifier = modifier, shape = RoundedCornerShape(20.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
                .padding(32.dp)
        ) {
            Column() {
                Text(
                    text = employee.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${employee.age}, ₹${employee.salary}",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface.copy(
                        alpha = 0.75f
                    )
                )
            }
            CircularUserImage(
                modifier = Modifier.align(Alignment.CenterEnd),
                url = employee.profilePic,
                errorDrawableRes = rememberSaveable(employee.id) {
                    listProfileRes.random()
                }
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EmployeeItemPreview() {
    EmployeeItem(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 100.dp),
        employee = getDummyEmployees().first()
    )
}