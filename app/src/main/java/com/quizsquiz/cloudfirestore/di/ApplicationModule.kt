package com.quizsquiz.cloudfirestore.di

import android.app.Application
import com.quizsquiz.cloudfirestore.MainViewModel
import com.quizsquiz.cloudfirestore.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
}