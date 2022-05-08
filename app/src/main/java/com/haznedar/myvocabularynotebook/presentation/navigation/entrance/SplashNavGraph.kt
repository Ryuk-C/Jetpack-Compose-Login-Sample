package com.haznedar.myvocabularynotebook.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.SPLASH_GRAPH_ROUTE
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.screen.SplashPage

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.splashNavGraph(
    navController: NavController
){

    navigation(startDestination = ScreenList.SplashScreen.route, route = SPLASH_GRAPH_ROUTE) {

        composable(route = ScreenList.SplashScreen.route){
            SplashPage(navController = navController, hiltViewModel())
        }

    }

}