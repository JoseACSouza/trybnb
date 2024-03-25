package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.RetrofitGetInstances
import com.betrybe.trybnb.data.models.Login
import com.betrybe.trybnb.ui.views.activities.MainActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ProfileFragment : Fragment() {

    private lateinit var mLoginInputLayout: TextInputLayout
    private lateinit var mPasswordInputLayout: TextInputLayout
    private lateinit var mLoginButton: Button
    private lateinit var mSuccessMsg: TextView
    private val api = RetrofitGetInstances.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mLoginInputLayout = view.findViewById(R.id.login_input_profile)
        mPasswordInputLayout = view.findViewById(R.id.password_input_profile)
        mLoginButton = view.findViewById(R.id.login_button_profile)

        mSuccessMsg = view.findViewById(R.id.success_login)

        mLoginButton.setOnClickListener {
            validateFields()
        }
        return view
    }

    private fun validateFields() {
            val validatePassword = mPasswordInputLayout.editText?.text.toString().isEmpty()
            val validateLogin =  mLoginInputLayout.editText?.text.toString().isEmpty()
            if(validateLogin){
                mLoginInputLayout.error = "O campo Login é obrigatório"
            }
            if(validatePassword){
                mPasswordInputLayout.error = "O campo Password é obrigatório"
            }
            if(!validateLogin && !validatePassword){
                mLoginInputLayout.error = null
                mPasswordInputLayout.error = null

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        // ADICIONAR ESSA LINHA
                        ApiIdlingResource.increment()
                        val response = api.authLogin(
                            Login(mLoginInputLayout.editText?.text.toString(),
                            mLoginInputLayout.editText?.text.toString())
                        )
                        if (response.isSuccessful){
                            println(response)
                            activity?.runOnUiThread {
                                mSuccessMsg.visibility = View.VISIBLE
                            }
                        }
                        //...
                        // Seu Codigo das Rotinas
                        // ...

                        // ADICIONAR ESSA LINHA
                        ApiIdlingResource.decrement()
                    } catch (e: HttpException) {
                        // ADICIONAR ESSA LINHA
                        ApiIdlingResource.decrement()
                        Log.e("Error", e.toString())
                        //...
                        // Seu Codigo de erro de HttpException
                        // ...
                    } catch (e: IOException) {
                        // ADICIONAR ESSA LINHA
                        ApiIdlingResource.decrement()
                        Log.e("Error", e.toString())
                        //...
                        // Seu Codigo de erro de IOException
                        // ...
                    }
                }

            }
    }

}