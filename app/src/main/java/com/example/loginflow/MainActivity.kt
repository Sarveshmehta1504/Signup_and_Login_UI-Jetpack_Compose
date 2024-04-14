package com.example.loginflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginflow.app.FoodApp
import com.example.loginflow.ui.theme.LoginflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodApp()
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    FoodApp()
}