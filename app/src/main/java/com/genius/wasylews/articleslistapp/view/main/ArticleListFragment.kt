package com.genius.wasylews.articleslistapp.view.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_list.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ArticleListFragment: BaseFragment(R.layout.fragment_article_list), ArticleListView {

    @Inject
    lateinit var presenterProvider: Provider<ArticleListPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private val adapter = ArticleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_articles.adapter = adapter
        recycler_articles.layoutManager = LinearLayoutManager(context)
    }

    override fun showItems(items: List<ArticleListItem>) {
        adapter.setList(items)
    }
}