package com.loc.newsapp.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

import com.loc.newsapp.presentation.onBoarding.Dimens.signInPadding
import com.loc.newsapp.ui.theme.NewsAppTheme


@Composable
fun SignInScreen(
    viewModel: SignInViewModel
) {
    val context = LocalContext.current
    val uiState by viewModel.state.collectAsState()
    val toastMessage by viewModel.toastMessage.collectAsState()

    LaunchedEffect(key1 = toastMessage) {
        if (toastMessage.isNotEmpty()) {
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    // Rest of your code...
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(signInPadding),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { viewModel.signIn("email@example.com", "password") }) {
            Text(text = "Sign In")
        }
    }
}
/*
@Preview
@Composable
fun signInPreview()
{
    NewsAppTheme {
        SignInScreen(viewModel = )

    }
}

 */