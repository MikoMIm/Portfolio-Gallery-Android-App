package com.company.esgallery.classes

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView

class Animations {
    companion object {
        fun moveTextViewUp(textView: TextView) {
            val anim = TranslateAnimation(0f, 0f, 0f, -500f).apply {
                duration = 500
                fillAfter = true
            }
            textView.startAnimation(anim)
        }

        fun fadeOutTextView(textView: TextView) {
            val anim = AlphaAnimation(1f, 0f).apply {
                duration = 500
                fillAfter = true
            }
            textView.startAnimation(anim)
            textView.visibility = View.GONE
        }

        fun fadeInButton(button: Button) {
            val anim = AlphaAnimation(0f, 1f).apply {
                duration = 500
                fillAfter = true
            }
            button.visibility = View.VISIBLE
            button.startAnimation(anim)
        }
    }
}