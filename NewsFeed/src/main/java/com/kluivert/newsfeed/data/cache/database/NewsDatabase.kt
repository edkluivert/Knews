package com.kluivert.newsfeed.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kluivert.newsfeed.data.cache.dao.NewsDao
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.utils.Converters


@Database(entities = [Article::class],version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase(){

    abstract val newsDao : NewsDao

    companion object{

        @Volatile
        private var INSTANCE : NewsDatabase? = null

        fun getInstance(context : Context) : NewsDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "bookmarks.db"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
            }

        }



    }

}