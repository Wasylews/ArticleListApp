package com.genius.wasylews.articleslistapp.domain.repository

import com.genius.wasylews.articleslistapp.data.db.ArticleDao
import com.genius.wasylews.articleslistapp.data.db.ArticleEntity
import com.genius.wasylews.articleslistapp.data.network.ArticleService
import com.genius.wasylews.articleslistapp.domain.model.Article
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleService: ArticleService,
    private val articleDao: ArticleDao
) {

    fun getArticles(categoryId: Int, page: Int, pageSize: Int): Single<List<Article>> {
        return fetchArticles(categoryId, page, pageSize)
            .onErrorComplete()
            .andThen(articleDao.getArticles(categoryId, page, pageSize))
            .toObservable()
            .flatMapIterable { it }
            .map { Article(it.title, it.picture, it.date, it.content) }
            .toList()
    }

    private fun fetchArticles(categoryId: Int, page: Int, pageSize: Int): Completable {
        return articleService.getArticles(categoryId, page, pageSize)
            .toObservable()
            .map { it.articles }
            .flatMapIterable { it }
            .map {
                ArticleEntity(
                    article_id = it.id,
                    title = it.title,
                    categoryId = it.category.id,
                    picture = it.picture,
                    date = it.date,
                    content = it.content
                )
            }
            .toList()
            .flatMapCompletable {
                articleDao.addArticles(it)
            }
    }
}