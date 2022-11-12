package com.example.hackatonumc3rd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackatonumc3rd.databinding.ActivityMapBinding
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class MapActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMapBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val mapView = MapView(this)
        val marker = MapPOIItem()
        val markerPoint = MapPoint.mapPointWithGeoCoord(37.49, 127.03)

        marker.itemName = "Me"
        marker.tag = 0
        marker.mapPoint = markerPoint
        marker.markerType = MapPOIItem.MarkerType.RedPin

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(37.49, 127.03), 3, true)
        mapView.addPOIItem(marker)

        val circle = MapCircle(MapPoint.mapPointWithGeoCoord(37.49, 127.03), 500, Color.argb(100, 255, 0, 0), Color.argb(85, 0, 255, 0))
        circle.tag = 1234
        mapView.addCircle(circle)
        viewBinding.mapView.addView(mapView)
    }
}
