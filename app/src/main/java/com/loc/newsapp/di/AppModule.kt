package com.loc.newsapp.di

import android.app.Application
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.data.local.NewsDatabase
import com.loc.newsapp.data.local.NewsTypeConvertor
import com.loc.newsapp.data.manager.LocalUserManagerimpl
import com.loc.newsapp.data.manager.remote.dto.NewsApi
import com.loc.newsapp.data.repository.AuthRepository
import com.loc.newsapp.data.repository.AuthRepositoryImpl
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.manager.repository.NewsRepository
import com.loc.newsapp.domain.manager.usecases.app_entry.AppEntryUseCases
import com.loc.newsapp.domain.manager.usecases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.manager.usecases.app_entry.SaveAppEntry
import com.loc.newsapp.domain.manager.usecases.news.DeleteArticle
import com.loc.newsapp.domain.manager.usecases.news.GetNews
import com.loc.newsapp.domain.manager.usecases.news.NewsUseCases
import com.loc.newsapp.domain.manager.usecases.news.SearchNews
import com.loc.newsapp.domain.manager.usecases.news.SelectArticle
import com.loc.newsapp.domain.manager.usecases.news.SelectArticles
import com.loc.newsapp.domain.manager.usecases.news.UpsertArticle
import com.loc.newsapp.util.Constants.BASE_URL
import com.loc.newsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }

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
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi, newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ) : NewsUseCases
    {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ):NewsDatabase
    {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao


}