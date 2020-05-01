package com.genius.wasylews.articleslistapp.di.module

import com.genius.wasylews.articleslistapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity
}