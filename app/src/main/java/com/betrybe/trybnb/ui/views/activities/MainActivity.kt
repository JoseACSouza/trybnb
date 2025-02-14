package com.betrybe.trybnb.ui.views.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybnb.R
import com.betrybe.trybnb.ui.views.fragments.CreateReservationFragment
import com.betrybe.trybnb.ui.views.fragments.ProfileFragment
import com.betrybe.trybnb.ui.views.fragments.ReservationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val mNavBar: BottomNavigationView by lazy {findViewById(R.id.navigation_bottom_view)}
    private val mFragmentProfile = ProfileFragment()
    private val mFragmentReservation = ReservationFragment()
    private val mFragmentCreateReservation = CreateReservationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.reservation_menu_item -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mFragmentReservation)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.create_reservation_menu_item -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mFragmentCreateReservation)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.profile_menu_tem -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mFragmentProfile)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
