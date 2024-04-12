import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.arvind.foodizone.R
import com.arvind.foodizone.ui.theme.colorBlack
import com.arvind.foodizone.ui.theme.colorBlue400
import com.arvind.foodizone.ui.theme.colorWhite
import com.arvind.foodizone.ui.theme.darkTheme
import com.arvind.foodizone.ui.theme.lightTheme
import com.arvind.foodizone.view.OrderScreen
import com.vishal.foodizone.navigation.Screen

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) darkTheme else lightTheme)
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcome),
                    contentDescription = "Welcome Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .height(450.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "Profile",
                style = MaterialTheme.typography.h6,
                color = colorBlack,
                modifier = Modifier.padding(16.dp)
            )
            // Update Profile option
            Text(
                text = "Update Profile",
                style = MaterialTheme.typography.body1,
                color = colorBlack,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        // Navigate to update profile screen
                    }
            )
            // Help and Support option
            Text(
                text = "Help and Support",
                style = MaterialTheme.typography.body1,
                color = colorBlack,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        // Navigate to help and support screen
                    }
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Logout option
            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.LoginScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorBlack),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 100.dp, end = 100.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "LogOut",
                    color = colorWhite,

                    style = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 1.dp, bottom = 1.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen(navController = NavController(LocalContext.current))
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ProfileScreenDarkPreview() {
    ProfileScreen(navController = NavController(LocalContext.current))
}
