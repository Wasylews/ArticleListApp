package com.genius.wasylews.articleslistapp.view.details

import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.navigation.fragment.navArgs
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.domain.model.Article
import com.genius.wasylews.articleslistapp.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_article_details.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class ArticleDetailsFragment: BaseFragment(R.layout.fragment_article_details), ArticleDetailsView {

    private val args: ArticleDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var presenterProvider: Provider<ArticleDetailsPresenter>

    private val presenter by moxyPresenter {
        presenterProvider.get().apply {
            article = args.article
        }
    }

    override fun showArticle(article: Article) {
        text_title.text = article.title
        text_content.text = HtmlCompat.fromHtml(article.content, FROM_HTML_MODE_LEGACY)
    }
}