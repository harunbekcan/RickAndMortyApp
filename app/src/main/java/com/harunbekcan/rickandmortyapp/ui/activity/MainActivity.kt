package com.harunbekcan.rickandmortyapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harunbekcan.rickandmortyapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}