package com.haznedar.myvocabularynotebook.presentation.navigation.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.SCAFFOLD_GRAPH_ROUTE
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.MainScreenPage
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.viewmodel.SettingsViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
fun NavGraphBuilder.scaffoldNavGraph(
    navController: NavController
){

    navigation(startDestination = ScreenList.MainScreen.route,
    SCAFFOLD_GRAPH_ROUTE){

        composable(ScreenList.MainScreen.route){

            MainScreenPage(navControllerScaffold = navController)
        }
    }
}