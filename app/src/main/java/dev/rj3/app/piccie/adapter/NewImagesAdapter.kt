package dev.rj3.app.piccie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.rj3.app.piccie.GlideApp
import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.adapter.NewImagesAdapter.ViewHolder
import dev.rj3.app.piccie.models.newUnsplahImages.UnsplashImage

class NewImagesAdapter(private val imageList: List<UnsplashImage>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.new_images_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentImage = imageList[position]
        holder.author.text = currentImage.user.name

        GlideApp.with(holder.itemView.context).load(currentImage.urls.small).into(holder.image)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.unsplashImage)
        val author: TextView = view.findViewById(R.id.imageAuthor)

    }
}