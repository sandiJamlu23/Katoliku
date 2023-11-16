package com.loc.newsapp.presentation.credo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.manager.model.Renungan
import com.loc.newsapp.domain.manager.usecases.news.NewsUseCases
import javax.inject.Inject

class CredoViewModel : ViewModel() {
    // LiveData to hold your Renungan objects
    private val _renungan = MutableLiveData<List<Renungan>>()
    val renungan: LiveData<List<Renungan>> = _renungan

    init {
        fetchRenungan()
    }

    private fun fetchRenungan() {
        // Fetch your Renungan objects here
        // This is just a placeholder. Replace with actual fetching code.
        _renungan.value = listOf(
            Renungan(1, "Author 1", "Title 1", "Description 1", "Content"),
            Renungan(2, "Author 2", "Title 2", "Description 2","Content"),
            Renungan(3, "Author 3", "Title 3", "Description 3","Content"),
            Renungan(4, "Author 4", "Title 4", "Description 4","Content"),
        )
    }
}
