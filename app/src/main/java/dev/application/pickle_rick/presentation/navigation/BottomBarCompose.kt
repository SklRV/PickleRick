package dev.application.pickle_rick.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.application.pickle_rick.R

@Composable
fun BottomBarCompose(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val screens = listOf(
        Routes.Characters,
        Routes.Favorite
    )

    NavigationBar(
        modifier = modifier,
        containerColor = Color.LightGray,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                label = { Text(text = screen.label) },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.label + stringResource(R.string.nav_bar_icon)) },
                selected = currentRoute == screen.route,
                onClick = { onBottomBarItemClick(navController = navController, screen = screen) },
                colors = navigationBarColors(),
            )
        }
    }
}

private fun onBottomBarItemClick(navController: NavHostController, screen: Routes) {
    navController.navigate(screen.route) {
        popUpTo(Routes.Characters.route)
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun navigationBarColors() =
    NavigationBarItemDefaults.colors(
        unselectedTextColor = colorResource(R.color.gray_dark),
        selectedTextColor = colorResource(R.color.blue),
        selectedIconColor = colorResource(R.color.blue),
        unselectedIconColor = colorResource(R.color.gray_dark),
        indicatorColor = colorResource(R.color.white)
    )
