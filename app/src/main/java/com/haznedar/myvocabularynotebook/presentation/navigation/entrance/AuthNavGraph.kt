package com.haznedar.myvocabularynotebook.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.AUTH_GRAPH_ROUTE
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.screen.LoginPage
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.screen.SignInPage
import com.haznedar.myvocabularynotebook.util.NoConnectionPage

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.authNavGraph(
    navController: NavController
){

    navigation(startDestination = ScreenList.LoginScreen.route, route = AUTH_GRAPH_ROUTE) {

        composable(route = ScreenList.LoginScreen.route){
            LoginPage(navController = navController)
        }

        composable(route = ScreenList.LoginScreen.route + "/{email}", arguments = listOf(

            navArgument("email") {

                type = NavType.StringType
                defaultValue = "Null"
                nullable = true

            }

        )

        ) {

            val email = it.arguments?.getString("email") ?: "Null"

            LoginPage(navController = navController, email = email)

        }

        composable(route = ScreenList.SignInScreen.route +"/{email}", arguments = listOf(

            navArgument("email") {

                type = NavType.StringType
                defaultValue = "Null"
                nullable = true

            }
        )
        ) {

            val email = it.arguments?.getString("email") ?: "Null"

            SignInPage(navController = navController, email = email)

        }

        composable(route = ScreenList.NoConnectionScreen.route){
            NoConnectionPage(navController = navController)
        }
    }
}