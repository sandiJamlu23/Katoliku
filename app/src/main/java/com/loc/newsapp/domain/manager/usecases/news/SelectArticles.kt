package com.loc.newsapp.domain.manager.usecases.news

import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.domain.manager.model.Article
import com.loc.newsapp.domain.manager.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

   operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}