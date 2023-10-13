package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerimpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.manager.usecases.AppEntryUseCases
import com.loc.newsapp.domain.manager.usecases.ReadAppEntry
import com.loc.newsapp.domain.manager.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerimpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager

    ) = AppEntryUseCases(
        readAppEntry =  ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}