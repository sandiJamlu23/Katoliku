package com.loc.newsapp.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.manager.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {
    val events = Channel<OnBoardingEvent>(Channel.BUFFERED)
    val eventsFlow = events.receiveAsFlow()

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
                viewModelScope.launch { events.send(OnBoardingEvent.NavigateToSignIn) }
            }
            // Handle other events...
            else -> {}
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
            events.send(OnBoardingEvent.NavigateToSignIn)
        }
    }
}
