package com.example.notificationsample.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import com.example.notificationsample.MainActivity
import com.example.notificationsample.R
import com.example.notificationsample.navigation.MY_ARG
import com.example.notificationsample.navigation.MY_URI
import com.example.notificationsample.receiver.MyReceiver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Singleton
    @Provides
    @MainNotificationCompatBuilder
    fun provideNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        val intent = Intent(context, MyReceiver::class.java).apply {
            putExtra("MESSAGE", "Clicked!")
        }
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            0
        }

        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, flag)
        val clickIntent = Intent(
            Intent.ACTION_VIEW,
            "$MY_URI/$MY_ARG=Coming from Notification.".toUri(),
            context,
            MainActivity::class.java
        )
        val clickPendingIntent: PendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(clickIntent)
            getPendingIntent(1, flag)
        }
        return NotificationCompat.Builder(context, "Main Channel ID")
            .setContentTitle("Do Sport")
            .setContentText("Did you exercise today?")
            .setSmallIcon(R.drawable.ic_do_sport)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(0, "ACTION", pendingIntent)
            .setContentIntent(clickPendingIntent)
    }

    @Singleton
    @Provides
    @SecondNotificationCompatBuilder
    fun provideSecondNotificationBuilder(@ApplicationContext context: Context): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, "Second Channel ID")
            .setSmallIcon(R.drawable.ic_do_sport)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
    }

    @Singleton
    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Main Channel ID",
                "Main Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val channel2 = NotificationChannel(
                "Second Channel ID",
                "Second Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }
        return notificationManager
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainNotificationCompatBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondNotificationCompatBuilder