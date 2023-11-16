package com.loc.newsapp.presentation.navgraph

sealed class Route(
val route: String
){
    object SignInScreen : Route(route = "signInScreen")
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object CredoScreen : Route(route = "credo")
    object BookmarkScreen : Route(route = "bookmarkScreen")
    object DetailsScreen : Route(route = "detailScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigationScreen : Route(route = "newsNavigator")

}
