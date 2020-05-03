package com.genius.wasylews.articleslistapp.data.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleModel(
    val id: Int,
    val title: String,
    @SerializedName("category") val category: ArticleCategory,
    val picture: String,
    @SerializedName("date_created") val date: Date,
    val content: String
)

data class ArticleCategory(val id: Int)

data class ArticleListResponse(
    val articles: List<ArticleModel>
)