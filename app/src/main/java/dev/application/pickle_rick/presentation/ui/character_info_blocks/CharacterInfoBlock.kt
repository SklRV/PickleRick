package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.presentation.ui.common.SpacerHeight

@Composable
fun CharacterInfoBlock(
    modifier: Modifier = Modifier,
    characterInfo: CharacterInfoModel,
    onLikeClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.gray_05))
    ) {
        item {
            CharacterInfoHeadBlock(characterInfo = characterInfo, onLikeClick = onLikeClick)
            CharacterInfoColumnBlock(characterInfo = characterInfo)
            SpacerHeight(16)
            CharacterInfoTextItem(icon = R.drawable.ic_episodes, title = R.string.info_text_episodes, text = "")
        }
        items(
            items = characterInfo.episodes
        ) { episode ->
            CharacterInfoEpisodeItem(text = episode.name, airDate = episode.airDate)
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun CharacterInfoBlockPreview() {
    CharacterInfoBlock(
        characterInfo = CharacterInfoModel(status = "Dead"),
        onLikeClick = {}
    )
}
