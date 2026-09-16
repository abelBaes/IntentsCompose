package br.edu.ifsp.scl.prdm.sc3039307.intentscompose.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.prdm.sc3039307.intentscompose.ui.compose.HomeScreen

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier){
    var currentText by remember { mutableStateOf("") }

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(
            route = Screen.HomeScreen.route
        ){ HomeScreen(
                currentText = currentText,
                modifier = modifier,
                nextScreenClick = {currentText ->
                    navHostController.navigate(
                        route = "${Screen.AddWordScreen.route}/${Uri.encode(currentText)}"
                    )
                },
                resetWorldClick = {currentText = ""}
            )
        }
    }
}