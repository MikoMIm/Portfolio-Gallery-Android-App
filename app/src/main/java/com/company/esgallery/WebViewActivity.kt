package com.company.esgallery

import android.annotation.SuppressLint
import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import javax.net.ssl.SSLContext


class WebViewActivity : AppCompatActivity() {

    companion object {
        private const val DEFAULT_URL = "https://www.example.com"
    }

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        initializeWebView()
        loadUrlFromIntent()
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Suppress("DEPRECATION")
    private fun initializeWebView() {
        webView = findViewById(R.id.webView)
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowContentAccess = true
            allowFileAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        sslContext.init(null, null, null)

        webView.webViewClient = object : WebViewClient() {
            @SuppressLint("WebViewClientOnReceivedSslError")
            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                handler?.proceed()
            }
        }
    }

    private fun loadUrlFromIntent() {
        val url = intent.getStringExtra("url") ?: DEFAULT_URL
        webView.loadUrl(url)
    }
}