package com.genius.wasylews.articleslistapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.genius.wasylews.articleslistapp.data.model.ArticleEntity
import io.reactivex.Completable

@Dao
interface ArticleDao {

    @Query("select * from articles where category_id = :categoryId")
    fun getArticles(categoryId: Int): List<ArticleEntity>

    @Insert
    fun addArticles(articles: List<ArticleEntity>): Completable
}