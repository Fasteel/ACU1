package com.example.acu1.ui.brand

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.acu1.R

@Composable
fun BrandHeader() {
    Image(
        painter = painterResource(id = R.drawable.ic_icon_fasteel),
        contentDescription = "Fasteel icon",
        modifier = Modifier.size(140.dp)
    )
    Text(
        "Fasteel",
        textAlign = TextAlign.Center,
        fontSize = 52.sp,
        color = Color(0xFF252B26),
    )
    Text(
        "Aspiring Android Developer",
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Right,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 64.dp),
        color = Color(0xFF323936),
        fontSize = 12.sp,
        fontStyle = FontStyle.Italic
    )
}