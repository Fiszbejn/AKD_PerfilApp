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
    isEditable: Boolean,
    isStudent: Boolean,
    onChangeStudent:(Boolean) -> Unit,
    flutter: Boolean,
    android: Boolean,
    ios: Boolean,
    experienceLevel: Int,
    onChangeExperienceLevel: () -> Unit,
    notificationAllowed: Boolean,
    onChangeNotificationAllowed: (Boolean) -> Unit
) {

    if(isEditable) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
        ) {
            Text("Nome:")
            OutlinedTextField(
                value = name,
                enabled = true,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Perfil:")
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = isStudent,
                    onClick = {onChangeStudent(!isStudent)}
                )
                Text("Aluno")
                Spacer(modifier = Modifier.weight(1f))
                RadioButton(
                    selected = isStudent,
                    onClick = {}
                )
                Text("Professor")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Interesses:")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = true,
                        onCheckedChange = {}
                    )
                    Text("Flutter")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = true,
                        onCheckedChange = {}
                    )
                    Text("Android")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = true,
                        onCheckedChange = {}
                    )
                    Text("IOS")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Nível de experiência: ${experienceLevel}")
            Slider(
                value = 4f,
                onValueChange = {},
                valueRange = 0.toFloat()..10.toFloat(),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Permitir notificação")
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = notificationAllowed,
                    onCheckedChange = {onChangeNotificationAllowed(!notificationAllowed)},
                )
            }
        }
    }
}


@Preview
@Composable
private fun PerfilFormPreview() {
    PerfilForm(name = "")
}