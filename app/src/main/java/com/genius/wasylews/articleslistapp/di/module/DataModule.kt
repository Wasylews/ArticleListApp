package com.genius.wasylews.articleslistapp.di.module

import android.content.Context
import androidx.room.Room
import com.genius.wasylews.articleslistapp.data.db.AppDatabase
import com.genius.wasylews.articleslistapp.data.db.ArticleDao
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideArticleDao(context: Context): ArticleDao {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME)
            .build()
            .getArticleDao()
    }
}