
package com.kr.ui_entry.ui.twitterAuthentication
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.net.Uri
import android.os.Build
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.coroutines.*
import twitter4j.auth.AccessToken
val coroutineScope = CoroutineScope(Dispatchers.IO)
var OauthToken = ""
var OauthTokensecret = ""
// A client to know about WebView navigations
// For API 21 and above
@OptIn(DelicateCoroutinesApi::class)
class TwitterWebViewClient : WebViewClient() {
    @SuppressLint("ObsoleteSdkInt")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        if (request?.url.toString().startsWith(TwitterConstants.CALLBACK_URL)) {
            Log.d("Authorization URL: ", request?.url.toString())
            handleUrl(request?.url.toString())
            // Close the dialog after getting the oauth_verifier
            if (request?.url.toString().contains(TwitterConstants.CALLBACK_URL)) {
                twitterDialog.dismiss()
            }
            return true
        }
        return false
    }
    // For API 19 and below
    @Deprecated("Deprecated in Java")
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (url.startsWith(TwitterConstants.CALLBACK_URL)) {
            Log.d("Authorization URL: ", url)
            handleUrl(url)
            // Close the dialog after getting the oauth_verifier
            if (url.contains(TwitterConstants.CALLBACK_URL)) {
                twitterDialog.dismiss()
            }
            return true
        }
        return false
    }
    // Get the oauth_verifier
     var accToken: AccessToken? = null
    lateinit var accToken1: String


    @SuppressLint("SuspiciousIndentation")
    private fun handleUrl(url: String) {

        val uri = Uri.parse(url)
        val oauthVerifier = uri.getQueryParameter("oauth_verifier") ?:""
        coroutineScope.launch {
            accToken = withContext(Dispatchers.IO) { twitter.getOAuthAccessToken(oauthVerifier) }


            getUserProfile()

        }
    }

    private suspend fun getUserProfile() {
        val usr = withContext(Dispatchers.IO) { twitter.verifyCredentials() }
        //Twitter Id
        val twitterId = usr.id.toString()
        Log.d("Twitter Id: ", twitterId)

        //Twitter Handle
        val twitterHandle = usr.screenName
        Log.d("Twitter Handle: ", twitterHandle)
        //Twitter Name
        val twitterName = usr.name
        Log.d("Twitter Name: ", twitterName)
        //Twitter Email
        val twitterEmail = usr.email
        Log.d("Twitter Email: ", twitterEmail ?: "'Request email address from users' on the Twitter dashboard is disabled")
        // Twitter Profile Pic URL
        val twitterProfilePic = usr.profileImageURLHttps.replace("_normal", "")
        Log.d("Twitter Profile URL: ", twitterProfilePic)
        // Twitter Access Token
        Log.d("Twitter Access Token", accToken?.token.toString())
       // Log.d("Twitter Access Token", accToken1)

            OauthToken = accToken?.token.toString()
            OauthTokensecret = accToken?.tokenSecret.toString()
    }
}



