package com.genius.wasylews.articleslistapp.di.module

import com.genius.wasylews.articleslistapp.view.details.ArticleDetailsFragment
import com.genius.wasylews.articleslistapp.view.main.ArticleListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun provideArticleListFragment(): ArticleListFragment

    @ContributesAndroidInjector
    fun provideArticleDetailsFragment(): ArticleDetailsFragment
}