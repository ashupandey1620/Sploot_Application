package com.ashutosh.splootapplication

import android.app.Application
import androidx.room.Room
import com.ashutosh.splootapplication.Data.NewsDatabase
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class newsApp: Application() {

    companion object {
        lateinit var database: NewsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            NewsDatabase::class.java, "news_database"
        ).build()
    }

}