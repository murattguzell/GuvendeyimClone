package com.muratguzel.myapplication.data.entity

import androidx.annotation.DrawableRes
import com.muratguzel.myapplication.R

sealed class OnBoardingScreenModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {

    data object FirstPage : OnBoardingScreenModel(
        image = R.drawable.enterphonenumber,
        title = "İlk Adım",
        description = "Güvendeyim uygulamasını kullanabilmek için ilk olarak en az 1 kişinin telefon numarasını kayıt etmeniz gerekiyor"
    )

    data object SecondPage : OnBoardingScreenModel(
        image = R.drawable.chatting_phone,
        title = "Güvendeyim!",
        description = "Olası bir deprem, yangın ya da farklı bir acil durumda butona tıkladığınız taktirde eklemiş olduğunuz telefon numaralarına konumunuz ve güvende olduğunuza dair SMS gönderilecektir"
    )


}