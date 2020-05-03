package com.genius.wasylews.articleslistapp.data.db

import androidx.room.*
import java.util.*

@Entity(
    tableName = "articles",
    indices = [Index(value = ["article_id"], unique = true)]
)
@TypeConverters(value = [DateConverter::class])
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val article_id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo val picture: String,
    @ColumnInfo val date: Date,
    @ColumnInfo val content: String
)