package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextFieldComponent
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordFieldComponent
import com.example.loginflow.components.UnderlineTextComponent
import com.example.loginflow.navigation.FoodAppRouter
import com.example.loginflow.navigation.Screen
import com.example.loginflow.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.Email),
                painterResource = painterResource(
                    id = R.drawable.message
                )
            )

            PasswordFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(
                    id = R.drawable.lock
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            UnderlineTextComponent(value = stringResource(id = R.string.forgot))
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComponent(value = stringResource(id = R.string.or))
            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                FoodAppRouter.navigateTo(Screen.SignUpScreen)
            })

        }

    }

    SystemBackButtonHandler {
        FoodAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}