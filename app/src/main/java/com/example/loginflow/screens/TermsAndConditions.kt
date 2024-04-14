package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.app.FoodApp
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.navigation.FoodAppRouter
import com.example.loginflow.navigation.Screen
import com.example.loginflow.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditions(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }
    SystemBackButtonHandler {
        FoodAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsPreview(){
    TermsAndConditions()
}