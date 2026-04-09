package com.davifiszbejn.perfilapp.components

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PerfilButton(
    isEditable: Boolean,
    onClickChangeEditable: (Boolean) -> Unit
) {

    OutlinedButton(
        onClick = {onClickChangeEditable(!isEditable)},
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(2.dp, color = ButtonDefaults.buttonColors().containerColor)
    ) {
        if(isEditable) Text("Salvar") else Text("Editar")
    }

}