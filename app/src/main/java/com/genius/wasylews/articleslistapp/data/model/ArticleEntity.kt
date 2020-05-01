package com.genius.wasylews.articleslistapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.genius.wasylews.articleslistapp.data.db.DateConverter
import java.util.*

@Entity(tableName = "articles")
@TypeConverters(value = [DateConverter::class])
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo val picture: String,
    @ColumnInfo val date: Date
)