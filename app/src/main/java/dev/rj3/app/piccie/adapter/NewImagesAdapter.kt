package dev.rj3.app.piccie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.rj3.app.piccie.GlideApp
import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.models.UnsplashImage

class NewImagesAdapter(val context:Context?,val imageList: List<UnsplashImage>) :
    RecyclerView.Adapter<NewImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewImagesAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.new_images_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: NewImagesAdapter.ViewHolder, position: Int) {
        val currentImage = imageList[position]
        holder.author.text = currentImage.user.name


        context?.let { GlideApp.with(it).load(currentImage.urls.small).into(holder.image) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.unsplashImage)
        val author = view.findViewById<TextView>(R.id.imageAuthor)

    }
}