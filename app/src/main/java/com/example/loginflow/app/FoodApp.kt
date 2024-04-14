package com.example.loginflow.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginflow.navigation.FoodAppRouter
import com.example.loginflow.navigation.Screen
import com.example.loginflow.screens.LoginScreen
import com.example.loginflow.screens.SignUpScreen
import com.example.loginflow.screens.TermsAndConditions

@Composable
fun FoodApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = FoodAppRouter.currentScreen) {currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TermsAndConditions -> {
                    TermsAndConditions()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
            }
            
        }
        
    }
}