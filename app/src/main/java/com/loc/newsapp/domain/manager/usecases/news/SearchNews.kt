package com.loc.newsapp.domain.manager.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.manager.model.Article
import com.loc.newsapp.domain.manager.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}