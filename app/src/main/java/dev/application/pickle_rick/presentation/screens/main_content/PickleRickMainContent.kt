package dev.application.pickle_rick.presentation.screens.main_content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.presentation.navigation.BottomBarCompose
import dev.application.pickle_rick.presentation.navigation.NavigationGraph
import dev.application.pickle_rick.presentation.navigation.Routes.CharacterInfo
import dev.application.pickle_rick.presentation.screens.all_characters.AllCharactersScreen
import dev.application.pickle_rick.presentation.screens.character_info.CharacterInfoScreen
import dev.application.pickle_rick.presentation.screens.favorite_characters.FavoriteCharactersScreen
import dev.application.pickle_rick.presentation.ui.filters_blocks.FiltersBottomSheetBlock
import dev.application.pickle_rick.presentation.ui.filters_blocks.FloatingActionFilterButton

@Composable
fun PickleRickMainContent() {
    val navController = rememberNavController()
    var charactersFilters by remember { mutableStateOf(CharactersFilters()) }
    var filtersButtonEnabled by remember { mutableStateOf(true) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBarCompose(navController = navController) },
        floatingActionButton = { FloatingActionFilterButton(filtersButtonEnabled) { showBottomSheet = it } }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(
                navController = navController,
                allCharactersScreen = {
                    filtersButtonEnabled = true
                    AllCharactersScreen(
                        filters = charactersFilters,
                        onItemBlockClick = { characterId -> navController.navigate(CharacterInfo.route + "/$characterId") }
                    )
                },
                favoriteCharactersScreen = {
                    filtersButtonEnabled = true
                    FavoriteCharactersScreen(
                        filters = charactersFilters,
                        onItemBlockClick = { characterId -> navController.navigate(CharacterInfo.route + "/$characterId") }
                    )
                },
                characterInfoScreen = { characterId ->
                    filtersButtonEnabled = false
                    CharacterInfoScreen(characterId = characterId)
                }
            )

            FiltersBottomSheetBlock(
                charactersFilters = charactersFilters,
                setCharactersFilter = { charactersFilters = it },
                showBottomSheet = showBottomSheet,
                setShowBottomSheet = { showBottomSheet = it },
            )
        }
    }
}
