package dev.application.pickle_rick.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R

@Composable
fun InternetProblemsBlock(
    modifier: Modifier = Modifier,
    onRefreshClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.error_internet_text),
            color = colorResource(R.color.gray_30),
            fontSize = TextUnit(16f, TextUnitType.Sp)
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(R.color.gray_05))
                .clickable { onRefreshClick() }
                .padding(8.dp),
            text = stringResource(R.string.error_refresh_text),
            color = colorResource(R.color.orange),
            fontSize = TextUnit(20f, TextUnitType.Sp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun InternetProblemsBlockPreview() {
    InternetProblemsBlock(
        onRefreshClick = {}
    )
}
