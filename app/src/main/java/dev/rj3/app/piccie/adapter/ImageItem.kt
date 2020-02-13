package dev.rj3.app.piccie.adapter

import coil.api.load
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

import dev.rj3.app.piccie.R
import dev.rj3.app.piccie.models.UnsplashImage
import kotlinx.android.synthetic.main.new_images_item.view.*

class ImageItem(private val image: UnsplashImage) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.new_images_item
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
      //  val currentImage = images[position]

        viewHolder.itemView.imageAuthor.text = image.user.name
        viewHolder.itemView.unsplashImageView.load(image.urls.small)
    }

}