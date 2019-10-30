package dev.rj3.app.piccie.db.newImages

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.rj3.app.piccie.models.newUnsplahImages.UnsplashImage

@Dao
interface UnsplashDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(unsplashImage: UnsplashImage)

@Query("Select * From Images")
    fun getImages(): LiveData<List<UnsplashImage>>
}
