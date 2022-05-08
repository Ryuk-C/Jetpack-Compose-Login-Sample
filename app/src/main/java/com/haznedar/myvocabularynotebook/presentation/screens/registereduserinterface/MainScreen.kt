package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.haznedar.myvocabularynotebook.presentation.navigation.bottombar.BottomBarNavigation
import com.haznedar.myvocabularynotebook.presentation.navigation.bottombar.BottomNavigation

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun MainScreenPage(
    navControllerScaffold: NavController
) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {

            BottomBarNavigation(navController = navController)

        }
    }
}
