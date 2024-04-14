package com.example.loginflow.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import com.example.loginflow.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.ui.theme.Primary
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginflow.ui.theme.GrayColor
import com.example.loginflow.ui.theme.Secondary
import com.example.loginflow.ui.theme.TextColor

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(labelValue: String, painterResource: Painter) {
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            containerColor = colorResource(id = R.color.InputTextField)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "profile_image")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(labelValue: String, painterResource: Painter) {
    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            containerColor = colorResource(id = R.color.InputTextField)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "profile_image")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckboxComponent(onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(start = 3.dp, end = 3.dp, top = 2.dp, bottom = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value != checkedState.value
        })
        ClickableTextComponents(onTextSelected)

    }
}

@Composable
fun ClickableTextComponents( onTextSelected: (String) -> Unit) {

    val initialText = "By continuing you accept our"
    val privacyAndPolicy = "Privacy Policy"
    val andText = " and "
    val termsAdConditionsText = "Terms of Use"
    val annotatedText = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyAndPolicy, annotation = privacyAndPolicy)
            append(privacyAndPolicy)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAdConditionsText, annotation = termsAdConditionsText)
            append(termsAdConditionsText)
        }

    }
    ClickableText(text = annotatedText, onClick = { offset ->
        annotatedText.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")
                if (span.item == termsAdConditionsText || span.item == privacyAndPolicy) {
                    onTextSelected(span.item)
                }

            }

    })
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun DividerTextComponent(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = GrayColor
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = value,
            fontSize = 14.sp,
            color = TextColor
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = GrayColor
        )
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean = true, onTextSelected: (String) -> Unit){
    val initialText = if(tryingToLogin) "Already have an account? " else "Don't have an account yet? "
    val loginText = if(tryingToLogin) "Login" else "Register"

    val annotatedText = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 21.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedText, onClick = { offset ->
        annotatedText.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")
                if (span.item == loginText) {
                    onTextSelected(span.item)
                }

            }

    })
}

@Composable
fun UnderlineTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}


@Preview
@Composable
fun Preview(){
    ButtonComponent(value = stringResource(id = R.string.register))
}

