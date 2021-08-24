package com.eazyalgo.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface RunDAO {

    // onConflict will replace the data with new data when conflicting
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC") // latest run will be at top of list
    fun getAllRunSortedByData(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunSortedByRunDuration(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calorieBurned DESC")
    fun getAllRunSortedByCalorieBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMP DESC")
    fun getAllRunSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis() : LiveData<Long>

    @Query("SELECT SUM(calorieBurned) FROM running_table")
    fun getTotalCalorieBurned() : LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters() : LiveData<Int>

    @Query("SELECT SUM(avgSpeedInKMP) FROM running_table")
    fun getTotalAvgSpeed() : LiveData<Float>

}