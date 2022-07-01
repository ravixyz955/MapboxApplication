package com.example.mapboxapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.maps.MapView
import com.mapbox.maps.ResourceOptionsManager
import com.mapbox.maps.Style
import com.mapbox.maps.TileStoreUsageMode
import com.mapbox.maps.extension.localization.localizeLabels
import java.util.*

var mapView: MapView? = null

@SuppressLint("Lifecycle")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ResourceOptionsManager.getDefault(this, getString(R.string.mapbox_access_token)).update {
            tileStoreUsageMode(TileStoreUsageMode.READ_ONLY)
        }
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.mapView)
//        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)
    }

    override fun onResume() {
        super.onResume()
        val locale = resources.configuration.locale
        mapView?.getMapboxMap()?.getStyle { style ->
            style.styleURI = Style.MAPBOX_STREETS
            style.localizeLabels(locale)
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}
