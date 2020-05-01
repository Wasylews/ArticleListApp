package com.genius.wasylews.articleslistapp.view.details

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.wasylews.articleslistapp.R
import kotlinx.android.synthetic.main.fragment_article_list.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ArticleDetailsFragment: MvpAppCompatFragment(R.layout.fragment_article_details), ArticleDetailsView {

    @Inject
    lateinit var presenterProvider: Provider<ArticleDetailsPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }
}