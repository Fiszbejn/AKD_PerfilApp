package com.davifiszbejn.perfilapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davifiszbejn.perfilapp.ui.theme.PerfilAppTheme

@Composable
fun PerfilAppScreen(modifier: Modifier) {

    var name by remember { mutableStateOf("") }
    var isStudent by remember { mutableStateOf(true) }
    var isEditable by remember { mutableStateOf(true) }
    var notificationAllowed by remember { mutableStateOf(true) }
    var experienceLevel by remember { mutableFloatStateOf(5f) }
    var flutter by remember { mutableStateOf(false) }
    var android by remember { mutableStateOf(false) }
    var ios by remember { mutableStateOf(false) }


    Column(
        modifier
            .padding(16.dp),
    ) {
        PerfilImage()
        Spacer(modifier = Modifier.height(16.dp))
        if(isEditable) {
            PerfilForm(
                name = name,
                onChangeName = {name = it},
                isStudent = isStudent,
                onChangeStudent = {isStudent = it},
                flutter = flutter,
                onChangeFlutter = {flutter = it},
                android = android,
                onChangeAndroid = {android = it},
                ios = ios,
                onChangeIos = {ios = it},
                experienceLevel = experienceLevel,
                onChangeExperienceLevel = {experienceLevel = it},
                notificationAllowed = notificationAllowed,
                onChangeNotificationAllowed = {notificationAllowed = it}
            )
        }else {
            PerfilResumo(
                name = name,
                isStudent = isStudent,
                flutter = flutter,
                android = android,
                ios = ios,
                experienceLevel = experienceLevel,
                notificationAllowed = notificationAllowed
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        PerfilButton(isEditable = isEditable, onClickChangeEditable = {isEditable = it})
    }
}

@Preview
@Composable
private fun PerfilAppScreenPreview() {
    PerfilAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            PerfilAppScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}