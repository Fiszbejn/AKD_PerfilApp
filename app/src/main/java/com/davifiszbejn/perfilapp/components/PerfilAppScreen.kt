package com.davifiszbejn.perfilapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davifiszbejn.perfilapp.ui.theme.PerfilAppTheme

@Composable
fun PerfilAppScreen(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var isStudent by remember { mutableStateOf(true) }
    var isEditable by remember { mutableStateOf(true) }
    var notificationAllowed by remember { mutableStateOf(true) }
    var experienceLevel by remember { mutableStateOf(5) }
    var flutter by remember { mutableStateOf(false) }
    var android by remember { mutableStateOf(false) }
    var ios by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        PerfilImage()
        Spacer(modifier = Modifier.height(16.dp))
        PerfilForm(name = "", onChangeStudent = {isStudent = it})
        Spacer(modifier = Modifier.weight(1f))
        PerfilButton()
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