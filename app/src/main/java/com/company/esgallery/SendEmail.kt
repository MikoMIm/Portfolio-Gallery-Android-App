package com.company.esgallery

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class SendEmail : AppCompatActivity() {
    private lateinit var buttonSend: Button
    private lateinit var editTextContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)

        buttonSend = findViewById(R.id.buttonSend)
        editTextContent = findViewById(R.id.editTextContent)

        buttonSend.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        val recipient = "stabledif122@gmail.com"
        val subject = "Roger Fenton app"
        val message = editTextContent.text.toString()

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        startActivity(Intent.createChooser(emailIntent, "Send email"))
    }
}