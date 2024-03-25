package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout
class CreateReservationFragment : Fragment() {

    private lateinit var mNameInputLayout: TextInputLayout
    private lateinit var mSurNameInputLayout: TextInputLayout
    private lateinit var mCheckinInputLayout: TextInputLayout
    private lateinit var mCheckoutInputLayout: TextInputLayout
    private lateinit var mAdditionalNeedsInputLayout: TextInputLayout
    private lateinit var mTotalPriceInputLayout: TextInputLayout
    private lateinit var mSendButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)
        mNameInputLayout = view.findViewById(R.id.first_name_create_reservation)
        mSurNameInputLayout = view.findViewById(R.id.last_name_create_reservation)
        mCheckinInputLayout = view.findViewById(R.id.checkin_create_reservation)
        mCheckoutInputLayout = view.findViewById(R.id.checkout_create_reservation)
        mAdditionalNeedsInputLayout = view.findViewById(R.id.additional_needs_create_reservation)
        mTotalPriceInputLayout = view.findViewById(R.id.total_price_create_reservation)
        mSendButton = view.findViewById(R.id.create_reservation_button)

        mSendButton.setOnClickListener {
            validateFields()
        }
        return view
    }

    private fun validateFields() {
        val validateName = mNameInputLayout.editText?.text.toString().isEmpty()
        val validateLastName =  mSurNameInputLayout.editText?.text.toString().isEmpty()
        val validateCheckin = mCheckinInputLayout.editText?.text.toString().isEmpty()
        val validateCheckout =  mCheckoutInputLayout.editText?.text.toString().isEmpty()
        val validateAdditionalNeeds = mAdditionalNeedsInputLayout.editText?.text.toString().isEmpty()
        val validateTotalPrice =  mTotalPriceInputLayout.editText?.text.toString().isEmpty()

        if(validateName){
            mNameInputLayout.error = "O campo Nome é obrigatório"
        }
        if(validateLastName){
            mSurNameInputLayout.error = "O campo Sobrenome é obrigatório"
        }
        if(validateCheckin){
            mCheckinInputLayout.error = "O campo Checkin é obrigatório"
        }
        if(validateCheckout){
            mCheckoutInputLayout.error = "O campo Checkout é obrigatório"
        }
        if(validateAdditionalNeeds){
            mAdditionalNeedsInputLayout.error = "O campo Necessidades Adicionais é obrigatório"
        }
        if(validateTotalPrice){
            mTotalPriceInputLayout.error = "O campo Preço Total é obrigatório"
        }
    }

}