package com.adobe.pixabaysample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adobe.pixabaysample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
    }
}
