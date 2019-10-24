package dev.rj3.app.piccie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.rj3.app.piccie.retrofit.UnsplashApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val unsplash = UnsplashApi()


        GlobalScope.launch(Dispatchers.Main) {

            val response = unsplash.getPhotos()

            GlideApp.with(this@MainActivity)
                .load(response[(Math.random() * response.size).toInt()].urls.small).into(imageView)


        }


    }
}
