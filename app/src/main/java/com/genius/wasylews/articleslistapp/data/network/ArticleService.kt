package com.genius.wasylews.articleslistapp.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    companion object {

        const val BASE_URL = "https://www.heikoschrang.de/applications/app/content/"
    }

    @GET("list")
    fun getArticles(@Query("category") category: Int,
                    @Query("page") page: Int,
                    @Query("per_page") pageSize: Int,
                    @Query("order") order: String = "desc"): Single<ArticleListResponse>
}