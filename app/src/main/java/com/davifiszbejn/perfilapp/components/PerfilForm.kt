package com.davifiszbejn.perfilapp.components

import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PerfilForm(
    name: String,
    onChangeName: (String) -> Unit,
    isStudent: Boolean,
    onChangeStudent: (Boolean) -> Unit,
    flutter: Boolean,
    onChangeFlutter: (Boolean) -> Unit,
    android: Boolean,
    onChangeAndroid: (Boolean) -> Unit,
    ios: Boolean,
    onChangeIos: (Boolean) -> Unit,
    experienceLevel: Float,
    onChangeExperienceLevel: (Float) -> Unit,
    notificationAllowed: Boolean,
    onChangeNotificationAllowed: (Boolean) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Text("Nome:")
        OutlinedTextField(
            value = name,
            enabled = true,
            onValueChange = { onChangeName(it) },
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Perfil:")
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = isStudent,
                onClick = { onChangeStudent(!isStudent) }
            )
            Text("Aluno")
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = !isStudent,
                onClick = { onChangeStudent(!isStudent) }
            )
            Text("Professor")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Interesses:")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = flutter,
                    onCheckedChange = { onChangeFlutter(it) }
                )
                Text("Flutter")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = android,
                    onCheckedChange = { onChangeAndroid(it) }
                )
                Text("Android")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = ios,
                    onCheckedChange = { onChangeIos(it) }
                )
                Text("IOS")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Nível de experiência: ${experienceLevel.toInt()}")
        Slider(
            value = experienceLevel,
            onValueChange = { onChangeExperienceLevel(it) },
            valueRange = 0.toFloat()..10.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Permitir notificação")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = notificationAllowed,
                onCheckedChange = { onChangeNotificationAllowed(it) },
            )
        }
    }
}