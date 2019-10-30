package dev.rj3.app.piccie.models.newUnsplahImages


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "Images")
data class UnsplashImage(
    @PrimaryKey val id: String,
    val color: String,
    val description: String?,
    @Json(name = "alt_description") val altDescription: String?,
    @Embedded(prefix = "urls_") val urls: Urls,
    @Ignore @Json(name = "links") val link: Link,
    var likes: Int,
    @Embedded(prefix = "user_") val user: User
)








