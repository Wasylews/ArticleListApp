package com.genius.wasylews.articleslistapp.view.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.model.Article
import com.genius.wasylews.articleslistapp.view.base.BaseFragment
import com.genius.wasylews.articleslistapp.view.main.custom.CategoryView
import com.genius.wasylews.articleslistapp.view.main.custom.LoadMoreView
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

        adapter.loadMoreModule.setOnLoadMoreListener {
            presenter.loadData()
        }
        adapter.loadMoreModule.loadMoreView = LoadMoreView()
        adapter.setHeaderView(getHeaderView())
        adapter.headerWithEmptyEnable = true
        adapter.setOnItemClickListener { _, _, position ->
            openArticleDetails(adapter.getItem(position).article)
        }

        recycler_articles.adapter = adapter
        recycler_articles.layoutManager = LinearLayoutManager(context)
    }

    private fun openArticleDetails(article: Article) {
        val direction = ArticleListFragmentDirections.showArticleDetails(article)
        findNavController().navigate(direction)
    }

    private fun getHeaderView(): View {
        val view = CategoryView(requireContext())
        view.setOnCategoryChangedListener {
            adapter.setNewInstance(null)
            presenter.changeCategory(it)
        }

        return view
    }

    override fun showLoading() {
        adapter.setNewInstance(null)
        adapter.setEmptyView(R.layout.layout_loading)
    }

    override fun showNoData() {
        adapter.setNewInstance(null)
        adapter.setEmptyView(R.layout.layout_no_data)
    }

    override fun showItems(items: List<ArticleItem>) {
        if (items.isEmpty()) {
            adapter.loadMoreModule.loadMoreEnd(true)
        } else {
            adapter.loadMoreModule.loadMoreComplete()
        }
        adapter.addData(items)
    }
}