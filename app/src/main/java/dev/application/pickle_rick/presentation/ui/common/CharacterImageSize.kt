package dev.application.pickle_rick.presentation.ui.common

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class CharacterImageSize {
    SMALL {
        override val size: Dp = 60.dp
        override val contourColourWidth: Dp = 3.dp
        override val contourWhiteWidth: Dp = 4.dp
    },
    BIG {
        override val size: Dp = 160.dp
        override val contourColourWidth: Dp = 6.dp
        override val contourWhiteWidth: Dp = 8.dp
    };

    abstract val size: Dp
    abstract val contourColourWidth: Dp
    abstract val contourWhiteWidth: Dp
}
