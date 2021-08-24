package com.eazyalgo.runningapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(
    var img: Bitmap? = null,  // we cannot directly store bitmap to database, we have to convert it to byteArray in Converter class
    var timeStamp: Long = 0,   // time stamp is defined in Long because it will be easier to sort them by date
    var avgSpeedInKMP: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0,  // duration of the run
    var calorieBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}