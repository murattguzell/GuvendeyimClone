package com.muratguzel.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muratguzel.myapplication.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Bu ekran için bir animasyon veya logo gösterebilirsiniz.
    // Bu örnekte CircularProgressIndicator kullanalım.

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Arka plan rengini belirleyebilirsiniz
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Logonuzu buraya koyabilirsiniz
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
            )


        }
        CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter).padding(32.dp), color = Color.Gray) // Yükleniyor göstergesi

    }

    // Burada 3 saniye sonra ekranın geçmesini sağlayacak bir zamanlayıcı kullanıyoruz.
    LaunchedEffect(Unit) {
        delay(3000) // 3 saniye bekle
        onTimeout() // Zamanlayıcı bitince ana ekranı göster
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen{

    }
}