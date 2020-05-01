package com.genius.wasylews.articleslistapp.view.main

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEnd

interface ArticleListView: MvpView {

    @AddToEnd
    fun showItems(items: List<ArticleListItem>)
}
