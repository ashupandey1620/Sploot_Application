package com.ashutosh.splootapplication.Data.News.Dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllItems(): Flow<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(cartitem: List<News>)

    @Query("DELETE FROM news")
    suspend fun clearCart()

    @Query("SELECT * FROM news WHERE url = :url LIMIT 1")
    suspend fun getNewsByUrl(url: String): News?
}