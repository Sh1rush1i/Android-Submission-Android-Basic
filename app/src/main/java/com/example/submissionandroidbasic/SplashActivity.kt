package com.example.submissionandroidbasic

import android.os.Handler
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {


    companion object {
        const val ANIMATION_TIME: Long = 3000
    }
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler(this.mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, ANIMATION_TIME)

    }

}