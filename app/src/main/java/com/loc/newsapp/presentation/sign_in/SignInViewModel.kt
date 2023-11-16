package com.loc.newsapp.presentation.sign_in

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val auth: FirebaseAuth,
): ViewModel() {
    val toastMessage = MutableStateFlow<String>("")
    val state = MutableStateFlow<SignInState>(SignInState.Initial)

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    // You can update some state here to reflect that the user is signed in
                } else {
                    // If sign in fails, display a message to the user.
                    toastMessage.value = "Sign in failed"
                }
            }
    }
}





