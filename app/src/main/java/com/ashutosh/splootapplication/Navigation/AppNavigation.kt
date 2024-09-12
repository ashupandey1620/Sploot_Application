package com.ashutosh.splootapplication.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.ashutosh.splootapplication.Presentation.NewsViewModel
import com.ashutosh.splootapplication.ui.theme.Screen.Main
import com.ashutosh.splootapplication.ui.theme.Screen.Splash


@Composable
fun AppNavigation(viewModel: NewsViewModel) {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Routes.Splash.name
    ) {

            composable(Routes.Splash.name) {
                Splash(
                    navController
                )
            }

            composable(Routes.Splash.name) {
                Main(
                    navController
                )
            }





    }
}


val NavHostController.isValidBackStack
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED


