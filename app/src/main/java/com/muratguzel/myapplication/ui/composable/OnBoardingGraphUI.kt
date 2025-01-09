package com.muratguzel.myapplication.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muratguzel.myapplication.data.entity.OnBoardingScreenModel

@Composable
fun OnboardingGraphUI(onBoardingScreenModel: OnBoardingScreenModel) {

    Column(modifier = Modifier.fillMaxSize().background(color = Color.White), verticalArrangement = Arrangement.Center) {


        Image(
            painter = painterResource(id = onBoardingScreenModel.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(500.dp)
                .padding(40.dp, 0.dp),
            alignment = Alignment.Center
        )
        Spacer(
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = onBoardingScreenModel.title,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(15.dp)
        )
        Text(
            text = onBoardingScreenModel.description,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(60.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnBoardingScreenModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnBoardingScreenModel.SecondPage)
}