package dev.rj3.app.piccie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.rj3.app.piccie.GlideApp
import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.retrofit.UnsplashApi
import kotlinx.android.synthetic.main.new_images_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewImagesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.new_images_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val unsplash = UnsplashApi()
        GlobalScope.launch(Dispatchers.Main) {

            val response = unsplash.getPhotos(2)

            GlideApp.with(this@NewImagesFragment)
                .load(response[(Math.random() * response.size).toInt()].urls.small).into(imageView)


        }
    }
}