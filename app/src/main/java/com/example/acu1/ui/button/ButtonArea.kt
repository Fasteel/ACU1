package com.example.acu1.ui.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.acu1.MyCardViewModel
import com.example.acu1.QrType
import com.example.acu1.R

@Composable
fun ButtonArea(viewModel: MyCardViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(
                alignment = Alignment.CenterVertically,
                space = 32.dp
            )
        ) {
            ButtonWithIcon(
                text = "+33684324449",
                onClick = {
                    viewModel.showAlert()
                },
                customIcon = {
                    Icon(
                        Icons.Rounded.Call,
                        contentDescription = "Phone icon",
                        tint = Color(0xFF323936),
                    )
                }
            )
            ButtonWithIcon(
                text = "Fasteel",
                onClick = {
                    viewModel.showBottomSheet(QrType.GITHUB)
                },
                customIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_github),
                        contentDescription = "Github icon",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(0.dp, 0.dp, 6.dp, 0.dp)
                    )
                }
            )
            ButtonWithIcon(
                text = "Carl MONNERA",
                onClick = {
                    viewModel.showBottomSheet(QrType.LINKEDIN)
                },
                customIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_linkedin),
                        contentDescription = "Linkedin icon",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(0.dp, 0.dp, 6.dp, 0.dp)
                    )
                }
            )
        }
    }

}
