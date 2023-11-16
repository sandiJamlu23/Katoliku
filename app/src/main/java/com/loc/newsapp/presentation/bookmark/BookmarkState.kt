package com.loc.newsapp.presentation.bookmark

import com.loc.newsapp.domain.manager.model.Article
import com.loc.newsapp.domain.manager.usecases.news.SelectArticles

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
