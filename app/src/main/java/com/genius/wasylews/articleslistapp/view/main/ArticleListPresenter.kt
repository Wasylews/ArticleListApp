package com.genius.wasylews.articleslistapp.view.main

import com.genius.wasylews.articleslistapp.domain.usecase.GetArticlesUseCase
import com.genius.wasylews.articleslistapp.view.base.BasePresenter
import com.genius.wasylews.articleslistapp.view.base.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ArticleListPresenter @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
): BasePresenter<ArticleListView>() {

    private var currentCategory = GetArticlesUseCase.Category.TV
    private var currentPage: Int = 0

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun loadData() {
        if (currentPage == 0) {
            viewState.showLoading()
        }
        getArticlesUseCase.getArticles(currentCategory, currentPage)
            .toObservable()
            .flatMapIterable { it }
            .map {
                ArticleItem(it)
            }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (currentPage == 0 && it.isEmpty()) {
                    viewState.showNoData()
                } else {
                    viewState.showItems(it)
                    currentPage++
                }
            }, {
                it.printStackTrace()
            }).addTo(compositeDisposable)
    }

    fun changeCategory(category: GetArticlesUseCase.Category) {
        currentPage = 0
        currentCategory = category
        loadData()
    }
}