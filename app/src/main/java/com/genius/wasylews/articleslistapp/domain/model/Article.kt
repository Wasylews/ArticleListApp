package com.genius.wasylews.articleslistapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Article(
    val title: String,
    val picture: String,
    val date: Date,
    val content: String
) : Parcelable
