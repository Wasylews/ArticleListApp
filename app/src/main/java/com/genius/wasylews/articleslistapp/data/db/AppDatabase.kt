package com.genius.wasylews.articleslistapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        const val NAME: String = "articles.db"
        const val VERSION = 1
    }
}