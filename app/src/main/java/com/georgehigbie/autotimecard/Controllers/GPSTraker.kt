package com.georgehigbie.autotimecard.Controllers

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

/**
 * Created by georgehigbie on 11/10/17.
 */
class GPSTraker(mmContext: Context) : LocationListener{

    internal var isGPSEnabled = false
    internal var isNetworkEnabled = false
    internal var canGetLocation = false
    internal var location: Location? = null
    internal var latitude: Double = 0.toDouble()
    internal var longitude: Double = 0.toDouble()

    protected var locationManager: LocationManager? = null
    private var mContext:Context = mmContext

    init {
        val m_location: Location? = getLocation()
    }

    fun getLocation(): Location?{
        try {
            locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            isGPSEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
            println("****isGPSEnabled****")
            isNetworkEnabled = locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            println("***isNetworkEnabled****")

        }catch(e: Exception){
            e.printStackTrace()
        }
        return location
    }

    fun stopUsingGPS(){
        if(locationManager != null){
            locationManager!!.removeUpdates(this@GPSTraker)
    }

    fun getLatitude(): Double{
        if(location != null){
            latitude = location!!.latitude
        }
    }

    fun getLongitude(): Double{
        if(location != null){
            longitude = location!!.longitude
        }
    }

    fun canGetLocation(): Boolean{
        return this.canGetLocation
    }

    override fun onLocationChanged(location: Location?) {}
    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
    override fun onProviderEnabled(provider: String?) {}
    override fun onProviderDisabled(provider: String?) {}

    companion object{
        private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 100 // 100 meters
        private val MIN_TIME_BW_UPDATES = (1000 * 60 * 1).toLong() // 60 seconds
    }


}
