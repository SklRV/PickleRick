package dev.application.pickle_rick.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import dev.application.pickle_rick.common.CHARACTERS
import dev.application.pickle_rick.common.CHARACTERS_INFO
import dev.application.pickle_rick.common.FAVORITE

sealed class Routes(val route: String, val icon: ImageVector, val label: String) {
    data object Characters : Routes(CHARACTERS, Icons.Default.Person, CHARACTERS)
    data object Favorite : Routes(FAVORITE, Icons.Default.Favorite, FAVORITE)
    data object CharacterInfo : Routes(CHARACTERS_INFO, Icons.Default.Info, CHARACTERS_INFO)
}
