package com.georgehigbie.autotimecard.Controllers

import android.content.Intent
import android.content.SharedPreferences
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.georgehigbie.autotimecard.R
import com.google.android.gms.location.LocationRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var locationManager: LocationManager? = null
    private var locationRequest: LocationRequest? = null
    private var appSettings: SharedPreferences? = null
    private var locationSet: Boolean = false
    private lateinit var testingText: TextView
    private val UPDATE_INTERVAL: Long = 10 * 1000 //good idea for now
    private val FASTEST_INTERVAL: Long = 2000 //good idea for now


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testingText = findViewById(R.id.testingText)

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
        locationRequest = LocationRequest()
        locationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

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

    fun MakeVolleyRequestForLocation(){



    }
}

