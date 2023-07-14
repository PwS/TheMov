package com.pws.themov.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pws.themov.databinding.ActivityChooseSeatBinding

class ChooseSeatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseSeatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSeatBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}