package com.genius.wasylews.articleslistapp.view.main

import android.view.View
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.entity.SectionEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.model.Article

abstract class ArticleListItem(override val isHeader: Boolean) : SectionEntity

data class TabsItem(val selectedTab: Int = 0): ArticleListItem(isHeader = true)

data class ArticleItem(val article: Article): ArticleListItem(isHeader = false)

class ArticleAdapter: BaseSectionQuickAdapter<ArticleListItem, BaseViewHolder>(
    R.layout.item_tabs,
    R.layout.item_article
) {

    override fun convert(holder: BaseViewHolder, item: ArticleListItem) {
        if (item is ArticleItem) {
            Glide.with(holder.itemView)
                .load(item.article.picture)
                .into(holder.getView(R.id.img_preview))

            holder.setText(R.id.text_title, item.article.title)
        }
    }

    override fun convertHeader(helper: BaseViewHolder, item: ArticleListItem) {
        val tabIds = arrayOf(R.id.btn_tv, R.id.btn_talk, R.id.btn_spirit)
        if (item is TabsItem) {
            tabIds.forEachIndexed { index, id ->
                val isCurrentTab = index == item.selectedTab
                helper.getView<View>(id).isSelected = isCurrentTab
            }
        }
    }
}