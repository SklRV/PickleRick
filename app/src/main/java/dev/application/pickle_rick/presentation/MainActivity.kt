package dev.application.pickle_rick.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.application.pickle_rick.presentation.screens.main_content.PickleRickMainContent
import dev.application.pickle_rick.presentation.ui.theme.PickleRickTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PickleRickTheme {
                PickleRickMainContent()
            }
        }
    }
}
