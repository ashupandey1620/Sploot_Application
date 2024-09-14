package com.ashutosh.splootapplication.Data.News.Dao


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news")
data class News(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String,
)

