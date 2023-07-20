package com.pws.themov.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivityMyWalletBinding

class MyWalletActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyWalletBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}