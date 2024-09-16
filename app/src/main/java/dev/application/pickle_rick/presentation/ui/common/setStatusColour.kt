package dev.application.pickle_rick.presentation.ui.common

import dev.application.pickle_rick.R
import dev.application.pickle_rick.common.STATUS_ALIVE
import dev.application.pickle_rick.common.STATUS_DEAD

fun setStatusColour(status: String): Int {
    return when (status) {
        STATUS_ALIVE -> R.color.green
        STATUS_DEAD -> R.color.red
        else -> R.color.blue
    }
}
