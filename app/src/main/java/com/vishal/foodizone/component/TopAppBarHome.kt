package com.vishal.foodizone.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arvind.foodizone.ui.theme.colorBlack
import com.arvind.foodizone.ui.theme.colorWhite
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.vishal.foodizone.view.OtpVerifyScreen

@Composable
fun TopAppBarHome() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .background(colorWhite)
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Dashboard,
                    contentDescription = "",
                    tint = colorBlack
                )

            }
        }

        var userselectaddress by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val locations = listOf("Arlington"
        ) // Your list of locations


        TextField(
            modifier = Modifier
                .height(50.dp)
                .weight(0.85f)
                .padding(start = 20.dp, end = 20.dp)
                .onFocusChanged {
                if (it.isFocused) {
                    expanded = true
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorWhite,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            value = userselectaddress,
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            onValueChange = { userselectaddress = it },
            placeholder = {
                Text(
                    text = "   Select Location",
                    color = colorBlack
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "",
                    tint = colorBlack
                )
            },

        )

        if (expanded) {
            DropdownMenu(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.CenterVertically),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                locations.forEach { location ->
                    DropdownMenuItem(onClick = {
                        userselectaddress = location
                        expanded = false
                    }) {
                        Text(text = location)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .background(colorWhite)
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "",
                    tint = colorBlack
                )

            }
        }

    }
}

@Composable
@Preview
fun TopAppBarHomeScreenPreview() {
    TopAppBarHome()
}
