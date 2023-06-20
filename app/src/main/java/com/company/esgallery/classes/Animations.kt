package com.company.esgallery.classes

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView

object Animations {
    private const val ANIMATION_DURATION = 500L

    fun moveTextViewUp(textView: TextView) {
        animateView(textView, TranslateAnimation(0f, 0f, 0f, -500f))
    }

    fun fadeOutTextView(textView: TextView) {
        val fadeIn = AlphaAnimation(0f, 1f).apply {
            duration = 500
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }

        textView.startAnimation(fadeIn)
    }

    fun fadeInButton(button: Button) {
        animateView(button, AlphaAnimation(0f, 1f))
        button.visibility = View.VISIBLE
    }

    private fun animateView(view: View, animation: Animation) {
        animation.duration = ANIMATION_DURATION
        animation.fillAfter = true
        view.startAnimation(animation)
    }
}
