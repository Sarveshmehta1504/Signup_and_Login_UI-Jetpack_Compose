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
import com.example.loginflow.components.CheckboxComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextFieldComponent
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordFieldComponent
import com.example.loginflow.navigation.FoodAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {
        Column (

            modifier = Modifier.fillMaxSize(),
        ){
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.sign_up))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.first_name), painterResource = painterResource(
                id = R.drawable.account
            ))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.last_name), painterResource = painterResource(
                id = R.drawable.account
            ))
            MyTextFieldComponent(labelValue = stringResource(id = R.string.email), painterResource = painterResource(
                id = R.drawable.email
            ))
            PasswordFieldComponent(labelValue = stringResource(id = R.string.password), painterResource = painterResource(
                id = R.drawable.lock
            ))
            CheckboxComponent(
                onTextSelected = {
                    FoodAppRouter.navigateTo(Screen.TermsAndConditions)
                }
                )
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = stringResource(id = R.string.register))
            DividerTextComponent(value = stringResource(id = R.string.or))
            ClickableLoginTextComponent (tryingToLogin = true ,onTextSelected = {
                FoodAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }


}

@Preview
@Composable
fun PreviewOfSignUpScreen() {
    SignUpScreen()
}