package dev.application.pickle_rick.presentation.ui.filters_blocks

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.application.pickle_rick.R

@Composable
fun FloatingActionFilterButton(
    filtersButtonEnabled: Boolean,
    showBottomSheet: (Boolean) -> Unit
) {
    if (filtersButtonEnabled) {
        ExtendedFloatingActionButton(
            text = { Text(stringResource(R.string.main_activity_filters)) },
            icon = { Icon(Filled.Settings, contentDescription = stringResource(R.string.main_activity_filters_button)) },
            onClick = { showBottomSheet(true) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionFilterButtonPreview() {
    FloatingActionFilterButton(
        filtersButtonEnabled = true,
        showBottomSheet = { }
    )
}
