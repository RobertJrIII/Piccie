package dev.rj3.app.piccie.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.adapter.NewImagesAdapter

import dev.rj3.app.piccie.data.api.UnsplashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class NewImagesFragment : Fragment() {

    private lateinit var recyclerview: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.new_images_fragment, container, false)
        recyclerview = view.findViewById(R.id.newImagesRecyclerview)
        recyclerview.apply {

            val layoutManager = LinearLayoutManager(context)
            setLayoutManager(layoutManager)
            setHasFixedSize(true)

        }


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val unsplash = UnsplashApi()
        GlobalScope.launch(Dispatchers.Main) {

            val response = unsplash.getPhotos(1, 15)

            val adapter = NewImagesAdapter(response)
            recyclerview.adapter = adapter


        }


    }
}