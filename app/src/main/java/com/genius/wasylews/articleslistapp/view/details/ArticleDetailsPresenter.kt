package com.genius.wasylews.articleslistapp.view.details

import com.genius.wasylews.articleslistapp.di.scope.PerFragment
import com.genius.wasylews.articleslistapp.domain.model.Article
import com.genius.wasylews.articleslistapp.view.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
@PerFragment
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