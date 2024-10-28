package com.example.acu1.ui.button

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun ButtonWithIcon(onClick: () -> Unit, text: String, customIcon: @Composable () -> Unit) {
    Button(
        colors = ButtonColors(
            containerColor = Color(0xff4E7154),
            contentColor = Color(0xFF323936),
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        onClick = {
            onClick()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            customIcon()
            Text(
                text,
                color = Color(0xFF323936),
            )
        }
    }
}