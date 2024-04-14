package com.example.loginflow.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object  SignUpScreen :  Screen()
    object TermsAndConditions: Screen()
    object LoginScreen: Screen()

}

object FoodAppRouter{
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}