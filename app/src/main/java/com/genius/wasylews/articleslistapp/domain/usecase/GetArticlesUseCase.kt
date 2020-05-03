package com.genius.wasylews.articleslistapp.domain.usecase

import com.genius.wasylews.articleslistapp.domain.model.Article
import com.genius.wasylews.articleslistapp.domain.repository.ArticleRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    enum class Category(val value: Int) {
        TV(1),
        TALK(2),
        SPIRIT(3)
    }

    companion object {
        const val PAGE_SIZE = 10
    }

    fun getArticles(category: Category, page: Int): Single<List<Article>> =
        articleRepository.getArticles(category.value, page, PAGE_SIZE)
}