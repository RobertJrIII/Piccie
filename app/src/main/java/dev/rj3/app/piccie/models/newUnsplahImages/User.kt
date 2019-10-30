package dev.rj3.app.piccie.models.newUnsplahImages

import com.squareup.moshi.Json

data class User(
    val id: String,
    val username: String,
    val name: String,
    @Json(name = "total_photos") val totalPhotos: Int

)