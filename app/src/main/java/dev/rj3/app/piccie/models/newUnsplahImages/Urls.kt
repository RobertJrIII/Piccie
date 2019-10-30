package dev.rj3.app.piccie.models.newUnsplahImages

import com.squareup.moshi.Json

data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    @Json(name = "thumb") val thumbnail: String
)