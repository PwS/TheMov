package com.pws.themov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pws.themov.R
import kotlinx.android.synthetic.main.activity_on_boarding_two.btn_home

class OnBoardingTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        btn_home.setOnClickListener {
            startActivity(Intent(this@OnBoardingTwoActivity, OnBoardingThreeActivity::class.java))
        }

    }
}