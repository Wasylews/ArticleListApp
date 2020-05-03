package com.genius.wasylews.articleslistapp.view.details

import com.genius.wasylews.articleslistapp.domain.model.Article
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

interface ArticleDetailsView: MvpView {

    @AddToEnd
    fun showArticle(article: Article)
}
