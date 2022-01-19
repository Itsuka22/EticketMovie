package com.handoyo.eticketkotlin.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.handoyo.eticketkotlin.R
import com.handoyo.eticketkotlin.sign.SignInActivity

class OnBoardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        val BtnHome: Button = findViewById(R.id.btn_daftar)

        BtnHome.setOnClickListener {
            var intent = Intent(this@OnBoardingThreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}