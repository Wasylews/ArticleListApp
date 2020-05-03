package com.genius.wasylews.articleslistapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ArticleDao {

    @Query("select * from articles where category_id = :categoryId order by date desc limit :pageSize offset :pageSize * :page")
    fun getArticles(categoryId: Int, page: Int, pageSize: Int): Single<List<ArticleEntity>>

    @Insert
    fun addArticles(articles: List<ArticleEntity>): Completable
}