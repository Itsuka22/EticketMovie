package com.handoyo.eticketkotlin.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.handoyo.eticketkotlin.R
import com.handoyo.eticketkotlin.sign.SignInActivity

class OnBoardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        val BtnHome:Button = findViewById(R.id.btn_home)

        BtnHome.setOnClickListener {
            var intent = Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        val BtnDaftar:Button = findViewById(R.id.btn_daftar)

        BtnDaftar.setOnClickListener {
            var intent = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
            startActivity(intent)

        }

    }
}