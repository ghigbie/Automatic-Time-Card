package com.georgehigbie.autotimecard.Controllers

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.georgehigbie.autotimecard.R
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : PermissionsActivity(){

   // private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var locationManager: LocationManager? = null

    private var appSettings: SharedPreferences? = null
    private var locationSet: Boolean = false
    private var location: Location? = null
    private var testingLongText: TextView? = null
    private var testingLatText: TextView? = null



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

//
//    @SuppressLint("MissingPermission")
//    fun getLocation() { //This should be called by setLocationButton and changeLocationButton
//        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
//        val locationListener = object : LocationListener{
//            override fun onLocationChanged(location: Location?) {
//                var longitudeString: String = (location!!.longitude).toString()
//                var latitudeString: String = (location!!.latitude).toString()
//                testingLongText!!.text = "Longitude: $longitudeString"
//                testingLatText!!.text = "Latitude: $latitudeString"
//            }
//
//            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
//            override fun onProviderEnabled(provider: String?) {}
//            override fun onProviderDisabled(provider: String?) {}
//        }
//        locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener) //safe check supression
//
//    }

    fun getLocation(){
        requestPermissions(ACCESS_FINE_LOCATION, object : PermissionCallBack{
            override fun permissionGranted() {
                super.permissionGranted()
                Log.v("ACCESS_FINE_LOCATION", "GRANTED!!!")
                locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
                try{
                    locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
                }catch(ex: SecurityException){
                    Log.d("EXEC: ",  "Security Exception, no location available")
                }

            }

            override fun permissionDenied() {
                super.permissionDenied()
                Log.v("ACCESS_FINE_LOCATION", "DENIED!!!")
            }
        })
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            testingLongText?.text = location.longitude.toString()
            testingLatText?.text = location.latitude.toString()
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    //sets all onclick listeners for activity
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

