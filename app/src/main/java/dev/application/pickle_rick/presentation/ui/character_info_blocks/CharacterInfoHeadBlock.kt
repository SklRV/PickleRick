package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.presentation.ui.common.CharacterImage
import dev.application.pickle_rick.presentation.ui.common.PickleRickLikeIconBlock
import dev.application.pickle_rick.presentation.ui.common.CharacterImageSize.BIG

@Composable
fun CharacterInfoHeadBlock(
    modifier: Modifier = Modifier,
    characterInfo: CharacterInfoModel,
    onLikeClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CharacterImage(
            imageUrl = characterInfo.image,
            status = characterInfo.status,
            characterImageSize = BIG
        )
        PickleRickLikeIconBlock(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 8.dp, end = 8.dp)
                .size(60.dp),
            isFavorite = characterInfo.favorite,
            onLikeClick = onLikeClick,
        )
        CharacterInfoStatusBlock(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp, start = 56.dp),
            status = characterInfo.status
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterInfoHeadBlockPreview() {
    CharacterInfoHeadBlock(
        characterInfo = CharacterInfoModel(status = "Dead"),
        onLikeClick = {}
    )
}
