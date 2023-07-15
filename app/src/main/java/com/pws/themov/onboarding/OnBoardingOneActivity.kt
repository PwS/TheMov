package com.pws.themov.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivityOnBoardingOneBinding
import com.pws.themov.sign.sign_in.SignInActivity
import com.pws.themov.sign.util.Preferences

class OnBoardingOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingOneBinding
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = Preferences(this)

        ///If Already Read All OnBoarding Status , Then The OnBoarding Page will not Show again
        if (preferences.getValue("onBoarding") == "1") {
            ///RemoveAllPageBeforeCurrentPage
            finishAffinity()

            val intent = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {
            val intent = Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        binding.btnDaftar.setOnClickListener {

            preferences.setValue("onBoarding", "1")


            ///RemoveAllPageBeforeCurrentPage
            finishAffinity()

            val intent = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}