package com.kr.ui_entry.ui.twitterAuthentication

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.*
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

@Composable
fun TwitterScreen(
    onClicked: () -> Unit
) {
    var clicked by remember { mutableStateOf(false) }
    IconButton(onClick = {
        clicked=!clicked
    }, modifier = Modifier
        .background(Color.Unspecified)
        .fillMaxSize()) {

    }
    if (clicked) {

        getRequestToken()
        onClicked()
    }
}


//twitter
lateinit var twitter: Twitter
lateinit var twitterDialog: Dialog

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "ComposableNaming", "SetJavaScriptEnabled")
@Composable
private fun getRequestToken() {
    val context = LocalContext.current
 val coroutineScope = rememberCoroutineScope()

        val sharedPref = context.getSharedPreferences("twitter",Context.MODE_PRIVATE)
        sharedPref.edit().putString("oauth_token",OauthToken).apply()
        sharedPref.edit().putString("oauth_token_secret",OauthTokensecret).apply()

    coroutineScope.launch(Dispatchers.IO) {

        val builder = ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey(TwitterConstants.CONSUMER_KEY)
            .setOAuthConsumerSecret(TwitterConstants.CONSUMER_SECRET)
            .setIncludeEmailEnabled(true)
        val config = builder.build()
        val factory = TwitterFactory(config)
        twitter = factory.instance
        try {

            val requestToken = twitter.oAuthRequestToken
            withContext(Dispatchers.Main) {
                twitterDialog = Dialog(context)
                val webView = WebView(context)
                webView.isVerticalScrollBarEnabled = false
                webView.isHorizontalScrollBarEnabled = false
                webView.webViewClient = TwitterWebViewClient()
                webView.settings.javaScriptEnabled = true
                webView.loadUrl(requestToken.authorizationURL)
                twitterDialog.setContentView(webView)
                twitterDialog.show()
            }
        } catch (e: IllegalStateException) {
            Log.e("ERROR: ", e.toString())
        }
    }



}