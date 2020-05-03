package com.genius.wasylews.articleslistapp.di.module

import android.content.Context
import androidx.room.Room
import com.genius.wasylews.articleslistapp.data.db.AppDatabase
import com.genius.wasylews.articleslistapp.data.db.ArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    @Singleton
    fun provideArticleDao(context: Context): ArticleDao {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME)
            .build()
            .getArticleDao()
    }
}