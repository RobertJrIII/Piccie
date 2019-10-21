package dev.rj3.app.piccie.models

import com.squareup.moshi.Json

data class UnsplashImage(
    val id: String, val color: String,
    var likes: Int,
    val description: String, @Json(name = "alt_description") val altDescription: String,
    val urls: Urls, @Json(name = "links") val link: Link

)


data class Urls(
    val raw: String, val full: String,
    val regular: String, val small: String
    , @Json(name = "thumb") val thumbnail: String
)


data class Link(@Json(name = "download_location") val download: String)