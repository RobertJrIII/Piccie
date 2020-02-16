package dev.rj3.app.ripple.models


import com.squareup.moshi.Json

data class UnsplashImage(
    val id: String,
    val color: String,
    val description: String?,
    @Json(name = "alt_description") val altDescription: String?,
    val urls: Urls,
    @Json(name = "links") val link: Link,
    var likes: Int,
    val user: User
)


data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    @Json(name = "thumb") val thumbnail: String
)

data class Link(@Json(name = "download_location") val download: String)


data class User(
    val id: String,
    val username: String,
    val name: String,
    @Json(name = "total_photos") val totalPhotos: Int

)







