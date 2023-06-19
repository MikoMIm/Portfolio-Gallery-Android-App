package com.company.esgallery

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.company.esgallery.classes.Animations
import com.google.firebase.FirebaseApp


@Suppress("DEPRECATION")
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

            if (isConnectedToInternet()) {
                initializeApp()
            } else {
                showNoInternetDialog()
            }
        }

        private fun initializeApp() {
            setContentView(R.layout.activity_main)
            FirebaseApp.initializeApp(this)

            initializeViews()
            setClickListeners()
            setViewVisibility()
            startAnimation()
        }

        private fun initializeViews() {
            clickCaption = findViewById(R.id.clickCaption)
            textView1 = findViewById(R.id.textView)
            textView2 = findViewById(R.id.textView2)
            textView3 = findViewById(R.id.textView3)
            bGallery = findViewById(R.id.bGallery)
            bContact = findViewById(R.id.bContact)
            bBiography = findViewById(R.id.bBiography)
        }

        private fun setClickListeners() {
            bBiography.setOnClickListener {
                startActivity(Intent(this, BiographyActivity::class.java))
            }

            bGallery.setOnClickListener {
                startActivity(Intent(this, GalleryActivity::class.java))
            }

            bContact.setOnClickListener {
                startActivity(Intent(this, SendEmail::class.java))
            }
        }

        private fun setViewVisibility() {
            bGallery.visibility = View.INVISIBLE
            bContact.visibility = View.INVISIBLE
            bBiography.visibility = View.INVISIBLE
        }

    private fun startAnimation() {
        val rootLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val textView1 = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val bGallery = findViewById<Button>(R.id.bGallery)
        val bContact = findViewById<Button>(R.id.bContact)
        val bBiography = findViewById<Button>(R.id.bBiography)
        val clickCaption = findViewById<TextView>(R.id.clickCaption)

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

    private fun isConnectedToInternet(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

        private fun showNoInternetDialog() {
            setContentView(R.layout.layout_no_internet)
            val resetButton = findViewById<Button>(R.id.resetButton)
            resetButton.setOnClickListener {
                if (isConnectedToInternet()) {
                    initializeApp()
                } else {
                    showNoInternetDialog()
                }
            }

        }
    }