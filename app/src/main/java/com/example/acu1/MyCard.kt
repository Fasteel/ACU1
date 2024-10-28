package com.example.acu1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.acu1.ui.bottomSheet.BottomSheetWithQrCode
import com.example.acu1.ui.brand.BrandHeader
import com.example.acu1.ui.button.ButtonWithIcon

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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = (-12).dp,
                    alignment = Alignment.Bottom
                ),
            ) {
                BrandHeader()
            }
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
