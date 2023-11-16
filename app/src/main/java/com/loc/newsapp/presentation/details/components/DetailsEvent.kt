package com.loc.newsapp.presentation.details.components

import com.loc.newsapp.domain.manager.model.Article

sealed class DetailsEvent {


   data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}