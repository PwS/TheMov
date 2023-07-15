package com.pws.themov.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivityOnBoardingThreeBinding
import com.pws.themov.sign.sign_in.SignInActivity

class OnBoardingThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            ///RemoveAllPageBeforeCurrentPage
            finishAffinity()

            val intent = Intent(this@OnBoardingThreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}