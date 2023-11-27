package com.loc.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.presentation.login_screen.SignInScreen
import com.loc.newsapp.presentation.login_screen.SignInViewModel
import com.loc.newsapp.presentation.news_navigator.components.NewsNavigator
import com.loc.newsapp.presentation.onBoarding.OnBoardingScreen
import com.loc.newsapp.presentation.onBoarding.OnBoardingViewModel
import com.loc.newsapp.presentation.sign_up.SignUpScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
    val signInViewModel: SignInViewModel = hiltViewModel()


    NavHost(
        navController = navController,
        startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){

            composable(route = Route.OnBoardingScreen.route
            ){
                OnBoardingScreen(
                    event = onBoardingViewModel::onEvent,
                    viewModel = onBoardingViewModel,
                    navController = navController
                )
            }
            composable(route = Route.SignInScreen.route
            ){
                SignInScreen(navController)
            }
            composable(route = Route.SignUpScreen.route
            ){
                SignUpScreen(navController)
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        )
        {
            composable(route= Route.NewsNavigationScreen.route){
                NewsNavigator()
            }
        }
    }


}