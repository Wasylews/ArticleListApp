package com.genius.wasylews.articleslistapp.view.details

import com.genius.wasylews.articleslistapp.R
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ArticleDetailsFragment: MvpAppCompatFragment(R.layout.fragment_article_details), ArticleDetailsView {

    @Inject
    lateinit var presenterProvider: Provider<ArticleDetailsPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }
}