package com.kr.ui_entry.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

@Suppress("DEPRECATION")
class FBLoginActivity : ComponentActivity() {

    private val callbackManager: CallbackManager by lazy {
        CallbackManager.Factory.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLogin()
        doLogin()

    }

    private fun doLogin() {
        LoginManager.getInstance().logInWithReadPermissions(
            this, listOf("email")
        )
    }

    private fun setupLogin() {
        LoginManager.getInstance()
            .registerCallback(callbackManager, callback = object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                    Log.d("TAG++", "facebook login cancelled")
                    setResult(RESULT_CANCELED)
                    finish()
                }

                override fun onError(error: FacebookException) {
                    Log.d("TAG++", "facebook login error")
                    setResult(RESULT_ERROR)
                    finish()
                }

                override fun onSuccess(result: LoginResult) {
                    Log.d("TAG++", "facebook login success")
                    Log.d("TAG++", "facebook login success ${result.authenticationToken?.claims?.email}")


          /*          val request = GraphRequest.newMeRequest(
                        result.accessToken,
                        callback = GraphRequest.GraphJSONObjectCallback { obj, response ->
                            val id: String = obj?.getString("id").toString()
                            val name: String = obj?.getString("name").toString()
                          //  val email: String = obj?.getString("email").toString()
                            // val pictureUri: String = obj?.getString("pictureUri").toString()
                            val picture: String = obj?.getString("picture").toString()

                            Log.e("facebookname1 : ", id)
                            Log.e("facebooklink1 : ", name)
                          //  Log.e("facebookmail1 : ", email)
                            Log.e("facebookpicture1 : ", picture)
                        })

                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,email,picture")

                    request.parameters = parameters
                    request.executeAsync()
                    Log.e("facebookparam : ", parameters.toString())
                    Log.e("facebook : ", result.accessToken.toString())

                    Log.e("facebook : ", result.accessToken.expires.toString())

                    Log.e("facebook : ", result.accessToken.userId)

                    Log.d("TAG+++++", "facebook login success ${result.authenticationToken?.claims?.email}")
*/

                    val intent = Intent().apply {
                        putExtra(EXTRA_DATA_FB, result.accessToken)
                    }
                    setResult(RESULT_OK, intent)
                    finish()

                }
            })
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


    companion object {

        const val RESULT_ERROR = 102
        const val EXTRA_DATA_FB = "extraDataFb"

        fun getInstance(context: Context): Intent {
            return Intent(context, FBLoginActivity::class.java)
        }
    }
}