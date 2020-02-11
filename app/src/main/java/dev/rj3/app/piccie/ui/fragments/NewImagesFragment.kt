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
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

const val PER_PAGE: Int = 25

class NewImagesFragment : Fragment() {

    private lateinit var recyclerview: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.new_images_fragment, container, false)
        recyclerview = view.findViewById(R.id.newImagesRecyclerview)
        val layoutManager = LinearLayoutManager(activity)
        recyclerview.apply {


            setLayoutManager(layoutManager)
            setHasFixedSize(true)

        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val unsplash = UnsplashApi()
        CoroutineScope(IO).launch {
            val response = unsplash.getPhotos(1, PER_PAGE)
            withContext(Main) {
                val adapter = NewImagesAdapter(response)
                recyclerview.adapter = adapter

            }


        }


    }
}