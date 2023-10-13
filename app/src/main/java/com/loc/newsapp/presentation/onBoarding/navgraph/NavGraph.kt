package com.loc.newsapp.presentation.onBoarding.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.loc.newsapp.presentation.onBoarding.OnBoardingScreen
import com.loc.newsapp.presentation.onBoarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
)
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination)
    {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent

                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        )
        {
            composable(route=Route.NewsNavigationScreen.route){
                Text(text = "News Navigator Screen")
            }
        }
    }


}