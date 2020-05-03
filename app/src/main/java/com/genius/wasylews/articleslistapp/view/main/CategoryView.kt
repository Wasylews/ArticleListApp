package com.genius.wasylews.articleslistapp.view.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.usecase.GetArticlesUseCase
import kotlinx.android.synthetic.main.item_tabs.view.*

typealias OnCategoryChangedListener = (category: GetArticlesUseCase.Category) -> Unit

class CategoryView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.item_tabs, this)
    }

    fun setOnCategoryChangedListener(l: OnCategoryChangedListener?) {
        btn_tv.setOnClickListener {
            l?.invoke(GetArticlesUseCase.Category.TV)
            updateView(it)
        }

        btn_talk.setOnClickListener {
            l?.invoke(GetArticlesUseCase.Category.TALK)
            updateView(it)
        }

        btn_talk.setOnClickListener {
            l?.invoke(GetArticlesUseCase.Category.SPIRIT)
            updateView(it)
        }
    }

    private fun updateView(view: View) {
        val tabs = listOf(btn_tv, btn_talk, btn_spirit)
        for (tab in tabs) {
            tab.isSelected = tab == view
        }
    }
}