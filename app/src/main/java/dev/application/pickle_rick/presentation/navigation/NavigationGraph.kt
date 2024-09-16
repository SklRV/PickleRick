package dev.application.pickle_rick.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.application.pickle_rick.common.CHARACTER_ID

@Composable
fun NavigationGraph(
    navController: NavHostController,
    allCharactersScreen: @Composable () -> Unit,
    favoriteCharactersScreen: @Composable () -> Unit,
    characterInfoScreen: @Composable (characterId: String) -> Unit,
) {
    NavHost(navController, startDestination = Routes.Characters.route) {
        composable(Routes.Characters.route) {
            allCharactersScreen()
        }
        composable(Routes.Favorite.route) {
            favoriteCharactersScreen()
        }
        composable(Routes.CharacterInfo.route + "/{$CHARACTER_ID}") { stackEntry ->
            val characterId = stackEntry.arguments?.getString(CHARACTER_ID) ?: ""
            characterInfoScreen(characterId)
        }
    }
}
