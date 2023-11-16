package com.loc.newsapp.domain.manager.usecases.news

import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.domain.manager.model.Article
import com.loc.newsapp.domain.manager.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article)
    {
        newsRepository.upsertArticle(article)
    }
}