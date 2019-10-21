package dev.rj3.app.piccie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import dev.rj3.app.piccie.models.UnsplashImage
import dev.rj3.app.piccie.retrofit.UnsplashApi
import dev.rj3.app.piccie.retrofit.UnsplashApiInstance
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val unsplash = UnsplashApiInstance.getInstance()

        val call = unsplash.getPhotos()




        call.enqueue(object : Callback<List<UnsplashImage>> {

            override fun onResponse(
                call: Call<List<UnsplashImage>>,
                response: Response<List<UnsplashImage>>
            ) {

                val images = response.body()

             Glide.with(this@MainActivity).load(images?.get(9)?.urls?.full).into(imageview)


            }

            override fun onFailure(call: Call<List<UnsplashImage>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        })


    }
}
