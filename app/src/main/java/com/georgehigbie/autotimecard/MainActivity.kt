package com.georgehigbie.autotimecard

import android.content.Context
import android.content.SharedPreferences
import android.location.LocationManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
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

    fun setButtonVisibility(){ //this should set the visibility of a button if location is set
        if(locationSet == false){

        }
    }


    fun getLocation() { //This should be called by setLocationButton and changeLocationButton
        if(locationManager == null) {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?

            var locationSet: Boolean = true
            appSettings = this.getSharedPreferences(com.georgehigbie.autotimecard.SHARED_PREFS_FILENAME, )

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
    }
}
