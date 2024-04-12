package com.arvind.foodizone.view.bottom

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.foodizone.R
import com.arvind.foodizone.component.NetworkImage
import com.vishal.foodizone.component.TopAppBarHome
import com.arvind.foodizone.ui.theme.*

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else colorBlue500)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            TopAppBarHome()
            Spacer(modifier = Modifier.height(30.dp))
            Title()
            Spacer(modifier = Modifier.height(20.dp))
            Content()
        }

    }
}

@Composable
fun Title() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "     Trained & Verified\n" +
                    "Monthly Cook for Home",
            color = colorBlack,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun Content() {
    Column() {
        Header()



    }
}


@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var usersearch by remember { mutableStateOf("") }

        Card(
            modifier = Modifier.height(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorWhite,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = usersearch,
                shape = RoundedCornerShape(24.dp),
                singleLine = true,
                onValueChange = { usersearch = it },
                placeholder = {
                    Text(
                        text = "Search Chef",
                        color = Color.Gray
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = CircleShape)
                            .background(colorBlack)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.FilterList,
                                contentDescription = "",
                                tint = colorWhite
                            )
                        }
                    }
                },
            )
        }
    }

}



@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeScreenDarkPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}



