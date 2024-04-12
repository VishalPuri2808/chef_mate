package com.vishal.foodizone.navigation

import ProfileScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arvind.foodizone.view.*
import com.arvind.foodizone.view.bottom.*
import com.vishal.foodizone.view.CreateAccountScreen
import com.vishal.foodizone.view.ForgotPassword
import com.vishal.foodizone.view.LoginScreen
import com.vishal.foodizone.view.OtpVerifyScreen
import com.vishal.foodizone.view.PasswordReset
import com.vishal.foodizone.view.WelcomeScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(
            route = Screen.WelcomeScreen.route
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }

        composable(
            route = Screen.PasswordReset.route
        ) {
            PasswordReset(navController)
        }

        composable(
            route = Screen.ForgotPassword.route
        ) {
            ForgotPassword(navController)
        }
        composable(
            route = Screen.CreateAccountScreen.route
        ) {
            CreateAccountScreen(navController)
        }

        composable(
            route = Screen.OtpVerifyScreen.route
        ) {
            OtpVerifyScreen(navController)
        }
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.FavoriteScreen.route
        ) {
            FavoriteScreen(navController)
        }
        composable(
            route = Screen.SearchScreen.route
        ) {
            SearchScreen(navController)
        }
        composable(
            route = Screen.OrderScreen.route
        ) {
            OrderScreen(navController)
        }

        composable(
            route = Screen.ProfileScreen.route
        ) {
            ProfileScreen(navController)
        }


    }

}