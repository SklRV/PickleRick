package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharacterInfoModel

@Composable
fun CharacterInfoColumnBlock(
    modifier: Modifier = Modifier,
    characterInfo: CharacterInfoModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.gray_50))
    ) {
        CharacterInfoTextItem(icon = R.drawable.ic_name, title = R.string.info_text_name, text = characterInfo.name)
        CharacterInfoTextItem(icon = R.drawable.ic_species, title = R.string.info_text_species, text = characterInfo.species)
        CharacterInfoTextItem(icon = R.drawable.ic_status, title = R.string.info_text_status, text = characterInfo.status)
        CharacterInfoTextItem(icon = R.drawable.ic_type, title = R.string.info_text_type, text = characterInfo.type)
        CharacterInfoTextItem(icon = R.drawable.ic_gender, title = R.string.info_text_gender, text = characterInfo.gender)
        CharacterInfoTextItem(icon = R.drawable.ic_home, title = R.string.info_text_origin, text = characterInfo.originLocation)
        CharacterInfoTextItem(icon = R.drawable.ic_location, title = R.string.info_text_location, text = characterInfo.lastLocation)
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun CharacterInfoColumnBlockPreview() {
    CharacterInfoColumnBlock(
        characterInfo = CharacterInfoModel()
    )
}
