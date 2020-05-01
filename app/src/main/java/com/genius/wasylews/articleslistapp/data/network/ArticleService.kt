package com.genius.wasylews.articleslistapp.data.network

import com.genius.wasylews.articleslistapp.data.model.ArticleEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    companion object {

        const val BASE_URL = "https://www.heikoschrang.de/applications/app/content/"
    }

    @GET("/list")
    fun getArticles(@Query("category") category: Int,
                    @Query("page") page: Int,
                    @Query("per_page") perPage: Int,
                    @Query("order") order: String): Flowable<ArticleEntity>
}