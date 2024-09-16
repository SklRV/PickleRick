package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.presentation.ui.common.setStatusColour

@Composable
fun CharacterInfoStatusBlock(
    modifier: Modifier = Modifier,
    status: String
) {
    Text(
        modifier = modifier
            .rotate(-45f)
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(R.color.gray_50))
            .border(
                width = 2.dp,
                color = colorResource(id = setStatusColour(status)),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(4.dp),
        text = status,
        color = colorResource(id = setStatusColour(status)),
        fontSize = TextUnit(24f, TextUnitType.Sp),
        fontWeight = FontWeight.Black,
        fontFamily = FontFamily.SansSerif
    )
}

@Preview(showBackground = true)
@Composable
fun CharacterInfoStatusBlockPreview() {
    CharacterInfoStatusBlock(
        status = "Dead"
    )
}
