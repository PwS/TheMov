package com.pws.themov.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pws.themov.databinding.ActivityOnBoardingOneBinding
import com.pws.themov.sign.SignInActivity

class OnBoardingOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingOneBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnHome.setOnClickListener {
            val intent = Intent(this@OnBoardingOneActivity, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

        binding.btnDaftar.setOnClickListener {
            ///RemoveAllPageBeforeCurrentPage
            finishAffinity()

            val intent = Intent(this@OnBoardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}