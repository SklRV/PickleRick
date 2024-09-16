package dev.application.pickle_rick.presentation.ui.filters_blocks

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharactersFilters
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterApplyButton(
    modifier: Modifier = Modifier,
    selectedOption: CharactersFilters,
    sheetState: SheetState,
    setCharactersFilter: (CharactersFilters) -> Unit,
    setShowBottomSheet: (Boolean) -> Unit,
) {
    val scope = rememberCoroutineScope()
    Button(
        modifier = modifier,
        border = BorderStroke(2.dp, colorResource(R.color.gray_50)),
        onClick = {
            setCharactersFilter(
                CharactersFilters(
                    gender = selectedOption.gender,
                    status = selectedOption.status
                )
            )
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    setShowBottomSheet(false)
                }
            }
        }) {
        Text(
            text = stringResource(R.string.filters_apply_button),
            fontSize = 20.sp
        )
    }
}
