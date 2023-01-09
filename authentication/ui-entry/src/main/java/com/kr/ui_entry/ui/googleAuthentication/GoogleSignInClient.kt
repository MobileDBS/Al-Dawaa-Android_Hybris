package com.kr.ui_entry.ui.googleAuthentication

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.kr.ui_entry.R

fun getGoogleSignInClient(context: Context): GoogleSignInClient {
    val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//         Request id token if you intend to verify google user from your backend server
        //       .requestIdToken(context.getString(R.string.backend_client_id))
        .requestEmail()
        .build()

    return GoogleSignIn.getClient(context, signInOptions)
}