package com.company.esgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.company.esgallery.classes.Loader
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.FirebaseStorage


class BiographyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        val storage = FirebaseStorage.getInstance()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biography)

        val loader = Loader(this)
        val imageView = findViewById<ImageView>(R.id.imagePortrait)
        val imageIndex = "self-portrait" // Replace with the desired image index
        loader.loadImage(imageView, imageIndex)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", "https://en.wikipedia.org/wiki/Roger_Fenton")
            startActivity(intent)
        }
    }
}
