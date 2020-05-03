package com.genius.wasylews.articleslistapp.view.details

import com.genius.wasylews.articleslistapp.domain.model.Article
import com.genius.wasylews.articleslistapp.view.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ArticleDetailsPresenter @Inject constructor(

): BasePresenter<ArticleDetailsView>() {

    lateinit var article: Article

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        viewState.showArticle(article)
    }
}