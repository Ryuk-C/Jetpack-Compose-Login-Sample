package com.haznedar.myvocabularynotebook.presentation.navigation.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.AcademiaPage
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.ListPage
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.pomodoro.TimerPage
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.SettingsPage

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun BottomBarNavigation(

    navController: NavHostController

) {

    NavHost(navController = navController, startDestination = ScreenList.ListScreen.route) {

        composable(ScreenList.ListScreen.route) {
            ListPage(navController = navController)
        }


        composable(ScreenList.AcademiaScreen.route) {
            AcademiaPage()
        }
        composable(ScreenList.TimerScreen.route) {
            TimerPage()
        }

        composable(ScreenList.SettingsicScreen.route) {

            SettingsPage(navController)
        }

    }

}