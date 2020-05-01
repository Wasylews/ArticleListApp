package com.genius.wasylews.articleslistapp.di.module

import android.content.Context
import com.genius.wasylews.articleslistapp.App
import dagger.Binds
import dagger.Module

@Module(includes = [
    DataModule::class,
    ActivityModule::class,
    FragmentModule::class
])
interface AppModule {

    @Binds
    fun provideContext(app: App): Context
}