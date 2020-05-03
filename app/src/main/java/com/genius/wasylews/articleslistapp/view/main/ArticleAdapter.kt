package com.genius.wasylews.articleslistapp.view.main

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.model.Article
import java.text.SimpleDateFormat
import java.util.*

data class ArticleItem(val article: Article)

class ArticleAdapter: BaseQuickAdapter<ArticleItem, BaseViewHolder> (
    R.layout.item_article
), LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: ArticleItem) {
        Glide.with(holder.itemView)
            .load(item.article.picture)
            .into(holder.getView(R.id.img_preview))

        holder.setText(R.id.text_title, item.article.title)
        holder.setText(
            R.id.text_date,
            SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(item.article.date)
        )
    }
}