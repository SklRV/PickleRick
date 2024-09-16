package dev.application.pickle_rick.presentation.ui.filters_blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.presentation.ui.common.SpacerWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersBottomSheetBlock(
    modifier: Modifier = Modifier,
    charactersFilters: CharactersFilters,
    setCharactersFilter: (CharactersFilters) -> Unit,
    showBottomSheet: Boolean,
    setShowBottomSheet: (Boolean) -> Unit,
) {
    var selectedOption by remember { mutableStateOf(charactersFilters) }

    if (showBottomSheet) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = { setShowBottomSheet(false) },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp)
            ) {
                Row {
                    FilterGenderRadioButtons(
                        modifier = Modifier.weight(1f),
                        selectedOption = selectedOption,
                        setSelectedOption = { selectedOption = selectedOption.copy(gender = it) }
                    )
                    SpacerWidth(8)
                    FilterStatusRadioButtons(
                        modifier = Modifier.weight(1f),
                        selectedOption = selectedOption,
                        setSelectedOption = { selectedOption = selectedOption.copy(status = it) }
                    )
                }

                FilterApplyButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    selectedOption = selectedOption,
                    sheetState = sheetState,
                    setCharactersFilter = setCharactersFilter,
                    setShowBottomSheet = setShowBottomSheet,
                )
            }
        }
    }
}
