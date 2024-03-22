package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout
class ProfileFragment : Fragment() {

    private lateinit var mLoginInputLayout: TextInputLayout
    private lateinit var mPasswordInputLayout: TextInputLayout
    private lateinit var mLoginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mLoginInputLayout = view.findViewById(R.id.login_input_profile)
        mPasswordInputLayout = view.findViewById(R.id.password_input_profile)
        mLoginButton = view.findViewById(R.id.login_button_profile)

        mLoginButton.setOnClickListener {
            validateFields()
        }
        return view
    }

    private fun validateFields() {
            val validatePassword = mPasswordInputLayout.editText?.text.toString().isEmpty()
            val validateLogin =  mLoginInputLayout.editText?.text.toString().isEmpty()
            if(validateLogin && validatePassword){
                mLoginInputLayout.error = "O campo Login é obrigatório"
                mPasswordInputLayout.error = "O campo Password é obrigatório"
            }
            else if(validateLogin){
                mLoginInputLayout.error = "O campo Login é obrigatório"
            }
            else if(validatePassword){
                mPasswordInputLayout.error = "O campo Password é obrigatório"
            }
    }

}