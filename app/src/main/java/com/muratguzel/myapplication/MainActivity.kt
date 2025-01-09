package com.muratguzel.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.muratguzel.myapplication.ui.screens.OnboardingScreen

import com.muratguzel.myapplication.ui.screens.SplashScreen
import com.muratguzel.myapplication.ui.theme.GuvendeyimCloneTheme
import com.muratguzel.myapplication.util.OnBoardingUtils
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val onBoardingUtils by lazy { OnBoardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuvendeyimCloneTheme {

                var isSplashFinished by remember { mutableStateOf(false) }

                if (isSplashFinished) {
                    if (onBoardingUtils.isOnboardingCompleted()) {
                        ShowHomeScreen()
                    } else {
                        ShowOnboardingScreen()

                    }
                } else {
                    SplashScreen(onTimeout = {
                        isSplashFinished = true
                    })
                }
            }
        }
    }
    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onBoardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }


    }





@Composable
private fun ShowHomeScreen() {
    // Ana ekran içeriği
    Column {
        Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
    }
}
}
