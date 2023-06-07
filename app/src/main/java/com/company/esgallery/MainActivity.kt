package com.company.esgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import com.google.firebase.FirebaseApp;
import androidx.constraintlayout.widget.ConstraintLayout
import com.company.esgallery.classes.Animations



class MainActivity : AppCompatActivity() {

    private lateinit var clickCaption: TextView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var bGallery: Button
    private lateinit var bContact: Button
    private lateinit var bBiography: Button

    private var isAnimationPlayed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        bContact = findViewById(R.id.bContact)
        bGallery = findViewById(R.id.bGallery)
        bBiography = findViewById(R.id.bBiography)
        bBiography.setOnClickListener {
            val intent = Intent(this, BiographyActivity::class.java)
            startActivity(intent)
        }

        bGallery.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }
        bContact.setOnClickListener {
            val intent = Intent(this, SendEmail::class.java)
            startActivity(intent)
        }

        clickCaption = findViewById(R.id.clickCaption)
        textView1 = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        bGallery = findViewById(R.id.bGallery)
        bContact = findViewById(R.id.bContact)
        bBiography = findViewById(R.id.bBiography)

        bGallery.visibility = View.INVISIBLE
        bContact.visibility = View.INVISIBLE
        bBiography.visibility = View.INVISIBLE


        val fadeInAnimation = AlphaAnimation(0f, 1f).apply {
            duration = 500
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }
        clickCaption.startAnimation(fadeInAnimation)

        val rootLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        rootLayout.setOnClickListener {
            if (!isAnimationPlayed) {
                Animations.moveTextViewUp(textView1)
                Animations.moveTextViewUp(textView2)
                Animations.moveTextViewUp(textView3)
                Handler().postDelayed({

                    Animations.fadeInButton(bGallery)
                    Animations.fadeInButton(bContact)
                    Animations.fadeInButton(bBiography)
                }, 500)
                Animations.fadeOutTextView(clickCaption)

                isAnimationPlayed = true
            }
        }
    }
}