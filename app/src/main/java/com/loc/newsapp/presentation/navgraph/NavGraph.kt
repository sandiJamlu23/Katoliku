package com.loc.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.presentation.news_navigator.components.NewsNavigator
import com.loc.newsapp.presentation.onBoarding.OnBoardingScreen
import com.loc.newsapp.presentation.onBoarding.OnBoardingViewModel
import com.loc.newsapp.presentation.sign_in.SignInScreen
import com.loc.newsapp.presentation.sign_in.SignInViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent,
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(
                route = Route.SignInScreen.route
            ){
                val viewModel: SignInViewModel = hiltViewModel()
                SignInScreen(viewModel = viewModel)

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