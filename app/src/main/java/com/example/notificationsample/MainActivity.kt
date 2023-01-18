package com.example.notificationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.notificationsample.navigation.SetupNavGraph
import com.example.notificationsample.screen.MainScreen
import com.example.notificationsample.ui.theme.NotificationSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationSampleTheme {
                SetupNavGraph(navController = rememberNavController())
            }
        }
    }
}
