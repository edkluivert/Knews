package com.kluivert.newsfeed.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kluivert.newsfeed.data.model.Article


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookMarks(article: Article)

    @Query("SELECT * FROM bookmarks")
    fun getBookmarks() : LiveData<List<Article>>

    @Delete()
   suspend fun deleteBookmarks(article: Article)


}