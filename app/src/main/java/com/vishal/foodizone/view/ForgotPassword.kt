package com.vishal.foodizone.view

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.foodizone.R
import com.vishal.foodizone.navigation.Screen
import com.arvind.foodizone.ui.theme.*

@Composable
fun ForgotPassword(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) darkTheme else lightTheme)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            var userephonenumber by remember { mutableStateOf("") }
            val maxChar = 10
            TextField(
                singleLine = true,
                value = userephonenumber,
                leadingIcon = {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.flag),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(24.dp, 24.dp)
                                    .padding(start = 10.dp)
                            )
                            Text(
                                text = "+1",
                                color = colorBlack,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Canvas(
                                modifier = Modifier
                                    .height(24.dp)
                                    .padding(start = 10.dp)
                            ) {
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, size.height),
                                    strokeWidth = 2.0F
                                )
                            }
                        }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorWhite,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = {
                    Text(
                        text = "Enter Your Phone Number",
                        modifier = Modifier.padding(start = 10.dp)
                    )
                },
                shape = RoundedCornerShape(24.dp),
                onValueChange = {
                    if (it.length <= maxChar) userephonenumber = it
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.OtpVerifyScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorBlack),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),

                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Send OTP ",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(140.dp))

        }

    }
}

@Composable
@Preview
fun ForgotPasswordPreview() {
    ForgotPassword(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ForgotPasswordDarkPreview() {
    ForgotPassword(navController = NavController(LocalContext.current))

}