package com.georgehigbie.autotimecard.Controllers

import android.content.Intent
import android.content.SharedPreferences
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.georgehigbie.autotimecard.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var locationManager: LocationManager? = null
    private var appSettings: SharedPreferences? = null
    private var locationSet: Boolean = false
    private var location: Location? = null
    private var testingLongText: TextView? = null
    private var testingLatText: TextView? = null

    private var currentLocation: CurrentLocation? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testingLongText = findViewById(R.id.testingLongText)
        testingLatText = findViewById(R.id.testingLatText)
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
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?
        try {
            locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
        }catch (ex: SecurityException){
            Log.d("PROBLEM!!! :", "Security Exception, no location available")
        }
    }

    fun getLocationUpdates(){

    }

    fun setOnClickListeners(){
        setLocationButton.setOnClickListener {
            getLocation()

        }

        changeLocationButton.setOnClickListener {

        }

        seeTimeCardButton.setOnClickListener {
            val timeCardIntent = Intent(this, TimeCard::class.java)
            startActivity(timeCardIntent)
        }
    }


}

