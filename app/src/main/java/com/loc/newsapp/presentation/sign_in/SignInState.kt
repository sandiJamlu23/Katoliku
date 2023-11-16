package com.loc.newsapp.presentation.sign_in

sealed class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
{
    object Initial : SignInState()
}
