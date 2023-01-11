package com.example.notificationsample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notificationsample.MainViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
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

        Button(
            onClick = mainViewModel::updateSimpleNotification,
            colors = buttonColors(backgroundColor = Blue),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Update Notification", color = Color.White, fontSize = 18.sp)
        }

        Button(
            onClick = mainViewModel::cancelSimpleNotification,
            colors = buttonColors(backgroundColor = Gray),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "Cancel Notification", color = Color.White, fontSize = 18.sp)
        }
    }
}