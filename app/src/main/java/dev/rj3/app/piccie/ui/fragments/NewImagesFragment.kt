package dev.rj3.app.piccie.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder


import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.adapter.ImageItem

import dev.rj3.app.piccie.api.UnsplashApi
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

const val PER_PAGE: Int = 25

class NewImagesFragment : Fragment() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.new_images_fragment, container, false)
        recyclerview = view.findViewById(R.id.newImagesRecyclerview)

        recyclerview.apply {

            setHasFixedSize(true)

        }

        adapter = GroupAdapter<GroupieViewHolder>()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val unsplash = UnsplashApi()

        CoroutineScope(IO).launch {


            withContext(Main) {


                recyclerview.adapter = adapter

            }


            val response = unsplash.getPhotos(1, PER_PAGE)



            for (image in response) {
                adapter.add(ImageItem(image))

            }


        }


    }
}