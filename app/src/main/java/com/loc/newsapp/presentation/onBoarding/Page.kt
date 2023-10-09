package com.loc.newsapp.presentation.onBoarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title:String,
    val description: String,
    @DrawableRes val image: Int

)
val pages = listOf(
    Page (
        title = "KatolikQu",
        description = "I am just truing to make this longer" +
                " so that the first screen is " +
                "displayed correctly",
        image = R.drawable.onboarding1
    ),
    Page (
        title = "Lorem Ipsum sdadafdasf fasfas fasf",
        description = "afasbfbn afasfbnas asfsnsfiaf afbsaf afa",
        image = R.drawable.onboarding2
    ),
    Page (
        title = "Lorem Ipsum sdadafdasf fasfas fasf",
        description = "afasbfbn afasfbnas asfsnsfiaf afbsaf afa",
        image = R.drawable.onboarding3
    ),
    Page (
        title = "Lorem Ipsum sdadafdasf fasfas fasf",
        description = "afasbfbn afasfbnas asfsnsfiaf afbsaf afa",
        image = R.drawable.onboarding4
)
)