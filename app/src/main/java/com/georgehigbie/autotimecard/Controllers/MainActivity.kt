package com.georgehigbie.autotimecard.Controllers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.location.LocationManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgehigbie.autotimecard.LOCATION_SET
import com.georgehigbie.autotimecard.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var locationManager: LocationManager? = null
    private var appSettings: SharedPreferences? = null
    private var locationSet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonVisibility()
        setOnClickListeners()
    }

    /*** This sets the visibility of the buttons if location is set or not set ***/
    fun setButtonVisibility(){ //sets the visibility of a button if location is set
        if(locationSet == false){
            setLocationButton.visibility = View.VISIBLE
            changeLocationButton.visibility = View.GONE
        }
    }


    fun getLocation() { //This should be called by setLocationButton and changeLocationButton
        if(locationManager == null) {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?

            var locationSet: Boolean = true
            val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(LOCATION_SET, locationSet)

        }
    }

    fun setOnClickListeners(){
        setLocationButton.setOnClickListener {
            getLocation();

        }

        changeLocationButton.setOnClickListener {

        }

        seeTimeCardButton.setOnClickListener {
            val timeCardIntent = Intent(this, TimeCard::class.java)
            startActivity(timeCardIntent)
        }
    }
}
