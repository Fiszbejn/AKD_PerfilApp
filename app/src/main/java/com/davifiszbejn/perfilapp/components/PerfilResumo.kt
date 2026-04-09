package com.davifiszbejn.perfilapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davifiszbejn.perfilapp.ui.theme.PerfilAppTheme

@Composable
fun PerfilResumo(
    name: String,
    isStudent: Boolean,
    flutter: Boolean,
    android: Boolean,
    ios: Boolean,
    experienceLevel: Float,
    notificationAllowed: Boolean
) {

    val interestsList = buildList {
        if(flutter) add("Flutter")
        if(android) add("Android")
        if(ios) add("IOS")
    }

    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Spacer(Modifier.height(48.dp))
        Row() {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Nome: ")
                        }
                        append(name)
                    }
                },
            )
        }
        Spacer(Modifier.height(24.dp))
        Row() {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Perfil: ")
                        }
                        append(if(isStudent) "Aluno" else "Professor")
                    }
                },
            )
        }
        Spacer(Modifier.height(24.dp))
        Column {
            Text("Interesses: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            interestsList.forEach {
                Text(" - ${it}", fontSize = 20.sp)
            }
        }
        Spacer(Modifier.height(24.dp))
        Row() {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Nível de experiência: ")
                        }
                        append(experienceLevel.toInt().toString())
                    }
                }
            )
        }
        Spacer(Modifier.height(24.dp))
        Row() {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Notificações: ")
                        }
                        append(if(notificationAllowed) "Permitidas" else "Não permitidas")
                    }
                }
            )
        }
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