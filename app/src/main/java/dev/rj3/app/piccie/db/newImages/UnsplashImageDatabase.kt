package dev.rj3.app.piccie.db.newImages

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.rj3.app.piccie.models.newUnsplahImages.UnsplashImage

@Database(
    entities = [UnsplashImage::class],
    version = 1


)
abstract class UnsplashImageDatabase : RoomDatabase() {


    abstract fun UnsplashImageDao(): UnsplashDao


    companion object {
        @Volatile
        private var instance: UnsplashImageDatabase? = null

        private val LOCk = Any()
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCk) {
            instance
                ?: buildDatabase(
                    context
                ).also { instance = it }

        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            UnsplashImageDatabase::class.java, "newimages.db"
        ).build()


    }

}