package com.handoyo.eticketkotlin.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.handoyo.eticketkotlin.R

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        val BtnHome: Button = findViewById(R.id.btn_homelanjutkan)

        BtnHome.setOnClickListener {
            var intent = Intent(this@OnBoardingTwoActivity, OnBoardingThreeActivity::class.java)
            startActivity(intent)
        }
    }


}