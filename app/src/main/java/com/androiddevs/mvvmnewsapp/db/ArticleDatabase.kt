package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.androiddevs.mvvmnewsapp.Article


@Database (
    entities = [Article::class],
    version = 1
)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }
    }

}