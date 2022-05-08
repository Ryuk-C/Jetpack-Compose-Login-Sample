package com.haznedar.myvocabularynotebook.presentation.navigation.tool

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.haznedar.myvocabularynotebook.presentation.navigation.authNavGraph
import com.haznedar.myvocabularynotebook.presentation.navigation.bottombar.scaffoldNavGraph
import com.haznedar.myvocabularynotebook.presentation.navigation.splashNavGraph

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SPLASH_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        authNavGraph(navController = navController)
        splashNavGraph(navController = navController)
        scaffoldNavGraph(navController = navController)
    }
}