package com.example.notificationsample.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notificationsample.MainViewModel
import com.example.notificationsample.navigation.Screen
import com.example.notificationsample.ui.theme.Purple200

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = mainViewModel::showSimpleNotification,
            colors = buttonColors(backgroundColor = Red),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Send Notification", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = mainViewModel::updateSimpleNotification,
            colors = buttonColors(backgroundColor = Blue),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Update Notification", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = mainViewModel::cancelSimpleNotification,
            colors = buttonColors(backgroundColor = Gray),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Cancel Notification", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                navController.navigate(Screen.Details.passArgument(message = "Coming from Main Screen."))
            },
            colors = buttonColors(backgroundColor = Purple200),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Details Screen", color = Color.White, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = mainViewModel::showProgress,
            colors = buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Show progress", color = Color.White, fontSize = 18.sp)
        }
    }
}