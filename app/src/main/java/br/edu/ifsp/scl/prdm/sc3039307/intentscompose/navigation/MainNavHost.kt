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

private const val NEW_TEXT_KEY = "new_text"

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier = Modifier) {
    var currentText by remember { mutableStateOf("") }

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) { backStackEntry ->
            val newWord = backStackEntry.savedStateHandle.get<String>(NEW_TEXT_KEY)

            if (!newWord.isNullOrEmpty()) {
                currentText = if (currentText.isEmpty()) {
                    newWord
                } else {
                    "$currentText $newWord"
                }
                backStackEntry.savedStateHandle.remove<String>(NEW_TEXT_KEY)
            }

            HomeScreen(
                currentText = currentText,
                modifier = Modifier,
                nextScreenClick = { textToPass ->
                    val encodedText = Uri.encode(textToPass.ifEmpty { " " })
                    navHostController.navigate(
                        route = "${Screen.AddWordScreen.route}/$encodedText"
                    )
                },
                resetWorldClick = {
                    currentText = ""
                }
            )
        }
        composable(
            route = "${Screen.AddWordScreen.route}/{textReceived}",
            arguments = listOf(
                navArgument("textReceived") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val textReceived = backStackEntry.arguments?.getString("textReceived")?.trim() ?: ""

            AddWordScreen(
                actualText = textReceived,
                modifier = Modifier,
                concatenateText = { typedText ->
                    navHostController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set(NEW_TEXT_KEY, typedText)
                    navHostController.popBackStack()
                }
            )
        }
    }
}