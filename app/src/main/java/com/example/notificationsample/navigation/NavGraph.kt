package com.example.notificationsample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notificationsample.screen.DetailScreen
import com.example.notificationsample.screen.MainScreen

const val MY_URI =
    "https://www.youtube.com/watch?v=u3fBdJzV5OY&list=PLSrm9z4zp4mFttjku-3wiRkPH1lDRQLYy&index=4"
const val MY_ARG = "message"

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(MY_ARG) { type = NavType.StringType }),
            deepLinks = listOf(navDeepLink { uriPattern = "$MY_URI/$MY_ARG={$MY_ARG}" })
        ) {
            val arguments = it.arguments
            arguments?.getString(MY_ARG)?.let { message ->
                DetailScreen(message = message)
            }
        }
    }
}