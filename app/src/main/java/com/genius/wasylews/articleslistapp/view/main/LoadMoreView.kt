package com.genius.wasylews.articleslistapp.view.main

import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView
import com.chad.library.adapter.base.util.getItemView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.genius.wasylews.articleslistapp.R

class LoadMoreView : BaseLoadMoreView() {

    override fun getLoadComplete(holder: BaseViewHolder): View {
        return holder.getView(R.id.loadmore_complete)
    }

    override fun getLoadEndView(holder: BaseViewHolder): View {
        return holder.getView(R.id.loadmore_end)
    }

    override fun getLoadFailView(holder: BaseViewHolder): View {
        return holder.getView(R.id.loadmore_error)
    }

    override fun getLoadingView(holder: BaseViewHolder): View {
        return holder.getView(R.id.loadmore_loading)
    }

    override fun getRootView(parent: ViewGroup): View {
        return parent.getItemView(R.layout.loading_view)
    }
}