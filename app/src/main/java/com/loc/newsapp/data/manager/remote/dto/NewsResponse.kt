package com.loc.newsapp.data.manager.remote.dto

import com.loc.newsapp.domain.manager.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)