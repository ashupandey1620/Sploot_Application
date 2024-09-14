package com.ashutosh.splootapplication.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashutosh.splootapplication.Data.News.Dao.News
import com.ashutosh.splootapplication.Data.News.Dao.NewsDao


@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
