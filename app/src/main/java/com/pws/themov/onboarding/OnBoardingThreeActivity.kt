package com.pws.themov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pws.themov.R
import com.pws.themov.sign.SignInActivity
import kotlinx.android.synthetic.main.activity_on_boarding_three.btn_home

class OnBoardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        btn_home.setOnClickListener {
            ///RemoveAllPageBeforeCurrentPage
            finishAffinity()

            val intent = Intent(this@OnBoardingThreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}