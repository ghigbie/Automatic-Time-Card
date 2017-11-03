package com.georgehigbie.autotimecard

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonVisibility()
        setOnClickListeners()
    }

    fun setButtonVisibility(){ //this should set the visibility of a button if location is set

    }


    fun getLocation() { //This should be called by setLocationButton and changeLocationButton
        if(locationManager == null) {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?


        }
    }

    fun setOnClickListeners(){
        setLocationButton.setOnClickListener {
            getLocation();
        }

        changeLocationButton.setOnClickListener {

        }
    }
}
