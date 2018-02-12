package com.example.ardin.alltherecipes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_recipe_detail.*


class RecipeDetailActivity : AppCompatActivity() {
    private var mWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val title = this.intent.getStringExtra("title")
        val url = this.intent.getStringExtra("url")

        setTitle(title)

        mWebView = detail_web_view as WebView
        this.mWebView!!.loadUrl(url)

    }
}
