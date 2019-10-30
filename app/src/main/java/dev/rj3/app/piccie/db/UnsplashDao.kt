package dev.rj3.app.piccie.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.rj3.app.piccie.models.UnsplashImage

//@Dao
//interface UnsplashDao {
//
//@Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun upsert(unsplashImage: UnsplashImage)
//
//@Query("Select * From unsplash_image")
//    fun getImages(): LiveData<List<UnsplashImage>>
//}