package com.genius.wasylews.articleslistapp.di.module

import com.genius.wasylews.articleslistapp.di.scope.PerActivity
import com.genius.wasylews.articleslistapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    @PerActivity
    fun provideMainActivity(): MainActivity
}