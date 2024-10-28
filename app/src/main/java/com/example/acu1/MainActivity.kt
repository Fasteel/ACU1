package com.example.acu1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.lifecycleScope
import com.example.acu1.ui.theme.ACU1Theme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

enum class Lang {
    EN,
    FR
}

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MyCardViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ACU1Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarColors(
                                containerColor = Color(0xff90A493),
                                titleContentColor = Color(0xff90A493),
                                scrolledContainerColor = Color(0xff90A493),
                                navigationIconContentColor = Color(0xff90A493),
                                actionIconContentColor = Color(0xff90A493),
                            ),
                            title = {
                                Text("")
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            contentColor = Color(0xff90A493),
                            containerColor = Color(0xff90A493),
                        ) {}
                    }
                ) { contentPadding ->
                    MyCard(contentPadding = contentPadding, viewModel = viewModel)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.startActivityEvent.collectLatest {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms_body", getMessageText(it))
                startActivity(this@MainActivity, intent, null)
            }
        }
    }
}
