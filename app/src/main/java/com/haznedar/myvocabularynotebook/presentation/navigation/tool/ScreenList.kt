package com.haznedar.myvocabularynotebook.presentation.navigation.tool

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.haznedar.myvocabularynotebook.R

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"
const val SPLASH_GRAPH_ROUTE = "splash"
const val SCAFFOLD_GRAPH_ROUTE = "scaffold"

sealed class ScreenList(

    val route: String,
    val title: String? = null,
    val icon: Int? = null

) {

    object SplashScreen : ScreenList("Splash_Screen")
    object LoginScreen : ScreenList("Login_Screen")
    object SignInScreen : ScreenList("SignIn_Screen")
    object MainScreen : ScreenList("Main_Screen")
    object NoConnectionScreen : ScreenList("No_Connection_Screen")

    object ListScreen : ScreenList("List_Screen", "Anasayfa", R.drawable.ic_list)
    object AcademiaScreen : ScreenList("Academia_Screen", "Akademi", R.drawable.ic_academia)
    object TimerScreen : ScreenList("Timer_Screen", "Pomodoro", R.drawable.ic_time)
    object SettingsicScreen : ScreenList("Settings_Screen", "Ayarlar", R.drawable.ic_settings)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
