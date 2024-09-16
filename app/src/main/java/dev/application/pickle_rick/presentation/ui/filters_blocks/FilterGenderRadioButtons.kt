package dev.application.pickle_rick.presentation.ui.filters_blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.domain.model.Gender
import dev.application.pickle_rick.domain.model.Gender.ALL

@Composable
fun FilterGenderRadioButtons(
    modifier: Modifier = Modifier,
    selectedOption: CharactersFilters,
    setSelectedOption: (Gender) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.filters_gender),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.SansSerif,
            textDecoration = TextDecoration.Underline
        )

        Gender.entries.toTypedArray().forEach { option ->
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = if (option != ALL) option.value else stringResource(id = R.string.filters_all),
                    style = MaterialTheme.typography.bodyLarge,
                )
                RadioButton(
                    selected = selectedOption.gender == option,
                    onClick = { setSelectedOption(option) }
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun FilterRadioButtonsPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        FilterGenderRadioButtons(
            selectedOption = CharactersFilters(),
            setSelectedOption = {}
        )
    }
}
