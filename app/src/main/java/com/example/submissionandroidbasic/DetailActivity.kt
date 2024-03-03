package com.example.submissionandroidbasic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        WindowCompat.setDecorFitsSystemWindows(
            window,false
        )

        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener {
            onBackPressed() // Kembali ke halaman sebelumnya
        }

        // Terima data dari intent
        val fruitName = intent.getStringExtra("fruit_name")
        val fruitDescription = intent.getStringExtra("fruit_description")
        val fruitPhoto = intent.getIntExtra("fruit_photo", 0)

        // Tampilkan data pada layout detail
        val detailImageView: ImageView = findViewById(R.id.prev_image)
        val detailNameTextView: TextView = findViewById(R.id.detal_textview)
        val detailDescriptionTextView: TextView = findViewById(R.id.desc_textview)

        detailImageView.setImageResource(fruitPhoto)
        detailNameTextView.text = fruitName
        detailDescriptionTextView.text = fruitDescription

        val shareButton = findViewById<Button>(R.id.action_share)
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareMessage = "Saya ingin berbagi tentang buah $fruitName: $fruitDescription"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Bagikan ke"))
        }
    }
}