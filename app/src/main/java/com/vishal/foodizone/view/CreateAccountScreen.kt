package com.vishal.foodizone.view

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arvind.foodizone.R
import com.vishal.foodizone.navigation.Screen
import com.arvind.foodizone.ui.theme.colorBlack
import com.arvind.foodizone.ui.theme.colorBlue400
import com.arvind.foodizone.ui.theme.colorPurpleLight700
import com.arvind.foodizone.ui.theme.colorWhite
import com.arvind.foodizone.ui.theme.darkTheme
import com.arvind.foodizone.ui.theme.lightTheme


@Composable
fun CreateAccountScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) darkTheme else lightTheme)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            var useremail by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(onClick = {
                    navController.navigate(Screen.ForgotPassword.route)
                })
                {Text(
                    text = "Create Account",
                    color = colorPurpleLight700,
                    style = MaterialTheme.typography.button.copy(
                        fontSize = 30.sp, // Adjust the fontSize as needed
                        fontWeight = FontWeight.ExtraBold),
                )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = useremail,
                leadingIcon = {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorWhite,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = "Email") },
                shape = RoundedCornerShape(24.dp),
                onValueChange = {
                    useremail = it
                })

            Spacer(modifier = Modifier.height(1.dp))

            var userType by remember { mutableStateOf("") }
            var expanded by remember { mutableStateOf(false) }
            val userTypes = listOf("Customer", "Chef")

            Box(

            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = userType,
                    leadingIcon = {
                        Row(
                            modifier = Modifier.wrapContentWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Contacts,
                                    contentDescription = "",
                                    tint = Color.Gray
                                )

                            }
                        )
                    },
                    onValueChange = {
                        userType = it
                    },
                    label = { Text("User Type") },
                    trailingIcon = {
                        IconButton(
                            onClick = { expanded = !expanded }
                        ) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Gray)
                        }
                    },
                    readOnly = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.White,
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        disabledBorderColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(24.dp),
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color.White)
                        .width(350.dp)
                ) {
                    userTypes.forEach { type ->
                        DropdownMenuItem(
                            onClick = {
                                userType = type
                                expanded = false
                            }
                        ) {
                            Text(text = type, color = Color.Gray) // Use Color.Gray for text color
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(10.dp))

            var usermobilenumber by remember { mutableStateOf("") }
            val maxChar = 10
            TextField(
                singleLine = true,
                value = usermobilenumber,
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
                        text = "Your Phone Number",
                        modifier = Modifier.padding(start = 10.dp)
                    )
                },
                shape = RoundedCornerShape(24.dp),
                onValueChange = {
                    if (it.length <= maxChar) usermobilenumber = it
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            var userpassword by remember { mutableStateOf("") }

            TextField(
                value = userpassword,
                onValueChange = { userpassword = it },
                leadingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password",
                            tint = Color.Gray
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("Password", fontSize = 14.sp) },
                shape = RoundedCornerShape(24.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorBlack),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Create account \uD83D\uDE0B",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.LoginScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorBlue400),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Login to account",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

        }

    }
}

@Composable
@Preview
fun CreateAccountScreenPreview() {
    CreateAccountScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CreateAccountScreenDarkPreview() {
    CreateAccountScreen(navController = NavController(LocalContext.current))

}
