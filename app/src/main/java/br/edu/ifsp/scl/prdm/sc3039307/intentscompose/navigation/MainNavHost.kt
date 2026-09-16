package br.edu.ifsp.scl.prdm.sc3039307.intentscompose.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose.AddWordScreen
import br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose.HomeScreen

private const val CURRENT_TEXT_KEY = "current_text"
private const val NEW_TEXT_KEY = "new_text"

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) { backStackEntry ->
            val currentSavedText = backStackEntry.savedStateHandle.get<String>(CURRENT_TEXT_KEY) ?: ""
            val newText = backStackEntry.savedStateHandle.get<String>(NEW_TEXT_KEY) ?: ""

            var currentText by remember(currentSavedText) { mutableStateOf(currentSavedText) }

            HomeScreen(
                currentText = currentText,
                modifier = modifier,
                nextScreenClick = { textToPass ->
                    navHostController.navigate(
                        route = "${Screen.AddWordScreen.route}/${Uri.encode(textToPass)}"
                    )
                },
                resetWorldClick = {
                    backStackEntry.savedStateHandle.set(CURRENT_TEXT_KEY, "")
                    currentText = ""
                }
            )
        }
        composable(
            route = "${Screen.AddWordScreen.route}/{textReceived}",
            arguments = listOf(
                navArgument("textReceived"){
                    type = NavType.StringType
                }
            )
        ) {
            backStackEntry ->
            AddWordScreen(
                actualText = backStackEntry.arguments?.getString("textReceived") ?: "",
                modifier = modifier,
                concatenateText = {
                    typedText ->
                    navHostController.previousBackStackEntry?.savedStateHandle?.set(NEW_TEXT_KEY, typedText)
                    navHostController.popBackStack()
                }
            )
        }
    }
}