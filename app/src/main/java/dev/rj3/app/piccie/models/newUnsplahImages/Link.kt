package dev.rj3.app.piccie.models.newUnsplahImages

import com.squareup.moshi.Json

data class Link(@Json(name = "download_location") val download: String)