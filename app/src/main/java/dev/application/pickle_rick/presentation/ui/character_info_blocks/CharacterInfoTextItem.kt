package dev.application.pickle_rick.presentation.ui.character_info_blocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.presentation.ui.common.LineSeparator
import dev.application.pickle_rick.presentation.ui.common.SpacerWidth

@Composable
fun CharacterInfoTextItem(
    modifier: Modifier = Modifier,
    icon: Int,
    title: Int,
    text: String
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(26.dp),
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = text + stringResource(R.string.info_text_icon)
            )
            SpacerWidth(8)
            Text(
                text = stringResource(title),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline,
            )
            SpacerWidth(32)
            Text(
                modifier = Modifier.weight(1f),
                text = text,
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
fun CCharacterInfoTextItemPreview() {
    CharacterInfoTextItem(
        icon = R.drawable.ic_gender,
        title = R.string.info_text_gender,
        text = "Male"
    )
}
