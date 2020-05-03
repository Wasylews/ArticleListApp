package com.genius.wasylews.articleslistapp.view.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.OneExecution

interface ArticleListView: MvpView {

    @AddToEnd
    fun showItems(items: List<ArticleItem>)

    @OneExecution
    fun showLoading()

    @OneExecution
    fun showNoData()
}
