package com.example.acu1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.acu1.ui.bottomSheet.BottomSheetWithQrCode
import com.example.acu1.ui.brand.BrandHeader
import com.example.acu1.ui.button.ButtonArea

// use weight on column

@Composable
fun MyCard(viewModel: MyCardViewModel, contentPadding: PaddingValues) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding),
        color = Color(0xff90A493)
    ) {
        if (viewModel.alertLangIsVisible.value) {
            AlertDialog(
                containerColor = Color(0xff90A493),
                icon = {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Location icon",
                        tint = Color(0xFF323936)
                    )
                },
                title = {
                    Text(
                        text = "Select the message language",
                        color = Color(0xFF323936)
                    )
                },
                onDismissRequest = {
                    viewModel.hideAlert()
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.triggerStartActivity(Lang.EN)
                            viewModel.hideAlert()
                        }
                    ) {
                        Text("English", color = Color(0xFF323936))
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            viewModel.triggerStartActivity(Lang.FR)
                            viewModel.hideAlert()
                        }
                    ) {
                        Text("French", color = Color(0xFF323936))
                    }
                }
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            BrandHeader()
            ButtonArea(viewModel)
        }
    }

    BottomSheetWithQrCode(
        isVisible = viewModel.bottomSheetType.value != QrType.NONE,
        onDismiss = {
            viewModel.hideBottomSheet()
        },
        qrCode = {
            if (viewModel.bottomSheetType.value == QrType.GITHUB) {
                Image(
                    painter = painterResource(id = R.drawable.qr_github),
                    contentDescription = "Github QR Code", // TODO use resource
                    modifier = Modifier.size(250.dp)
                )
            } else if (viewModel.bottomSheetType.value === QrType.LINKEDIN) {
                Image(
                    painter = painterResource(id = R.drawable.qr_linkedin),
                    contentDescription = "Linkedin QR Code", // TODO use resource
                    modifier = Modifier.size(250.dp)
                )
            }
        },
    )
}

fun getMessageText(lang: Lang): String {
    return when (lang) {
        Lang.EN -> """
                Hey! 👋

                It's me, Carl alias Fasteel, your favorite Android developer! 🤖

                Looking for a skilled Android developer to bring your app ideas to life? 🚀
                                                    
                Check out my portfolio and recent projects to see what I can build for you 🫵

                Linkedin: https://www.linkedin.com/in/carl-monnera-2457b8116/
                Github: https://github.com/Fasteel

                Let’s collaborate! 🤝
            """.trimIndent()

        Lang.FR -> """
                Hey! 👋
                
                C'est moi, Carl alias Fasteel, votre développeur Android préféré ! 🤖
                
                Vous recherchez un développeur Android qualifié pour donner vie à vos idées d'application? 🚀
                
                Consultez mon portfolio et mes projets récents pour voir ce que je peux construire pour vous 🫵
                                                        
                Linkedin: https://www.linkedin.com/in/carl-monnera-2457b8116/
                Github: https://github.com/Fasteel

                Collaborons! 🤝
            """.trimIndent()
    }
}
