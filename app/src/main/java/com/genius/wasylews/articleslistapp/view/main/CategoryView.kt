package com.genius.wasylews.articleslistapp.view.main

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.usecase.GetArticlesUseCase
import kotlinx.android.synthetic.main.view_category.view.*

typealias OnCategoryChangedListener = (category: GetArticlesUseCase.Category) -> Unit

class CategoryView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_category, this)
    }

    fun setOnCategoryChangedListener(l: OnCategoryChangedListener?) {
        group_tabs.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.btn_tv -> l?.invoke(GetArticlesUseCase.Category.TV)
                R.id.btn_talk -> l?.invoke(GetArticlesUseCase.Category.TALK)
                R.id.btn_spirit -> l?.invoke(GetArticlesUseCase.Category.SPIRIT)
            }
        }
    }
}