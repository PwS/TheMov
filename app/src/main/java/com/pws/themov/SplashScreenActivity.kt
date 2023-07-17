package com.pws.themov

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivitySplashScreenBinding
import com.pws.themov.onboarding.OnBoardingOneActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler()

        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity, OnBoardingOneActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}