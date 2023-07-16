package com.pws.themov.sign.sign_up

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivitySignUpPhotoscreenBinding

class SignUpPhotoScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpPhotoscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPhotoscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}