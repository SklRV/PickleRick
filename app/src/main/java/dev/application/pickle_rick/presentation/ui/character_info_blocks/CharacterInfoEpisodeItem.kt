package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.presentation.ui.common.LineSeparator
import dev.application.pickle_rick.presentation.ui.common.SpacerWidth

@Composable
fun CharacterInfoEpisodeItem(
    modifier: Modifier = Modifier,
    text: String,
    airDate: String,
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(colorResource(R.color.gray_50))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
            SpacerWidth(12)
            Text(
                modifier = Modifier.weight(1f),
                text = airDate,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
        }
        LineSeparator()
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterInfoEpisodeItemPreview() {
    CharacterInfoEpisodeItem(
        text = "Male",
        airDate = "September"
    )
}
