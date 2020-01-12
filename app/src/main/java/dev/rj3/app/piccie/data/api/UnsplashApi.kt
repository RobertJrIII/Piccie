package dev.rj3.app.piccie.data.api

import dev.rj3.app.piccie.BuildConfig
import dev.rj3.app.piccie.models.newUnsplahImages.UnsplashImage

import okhttp3.Interceptor
import okhttp3.OkHttpClient.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface UnsplashApi {

    @Headers("Accept-Version: v1")
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") pageNum: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>


    @GET("photos/{id}")
    suspend fun getAPhoto(@Path("id") id: String): UnsplashImage


    companion object {

        operator fun invoke(): UnsplashApi {
            val okhttpBuilder = Builder()

            okhttpBuilder.addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val request = chain.request()

                    val newRequest = request.newBuilder().header(
                        "Authorization",
                        "Client-ID ${BuildConfig.Client_ID}"
                    )
                    return chain.proceed(newRequest.build())

                }
            }


            )

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .client(okhttpBuilder.build())
                .addConverterFactory(MoshiConverterFactory.create())



            return retrofitBuilder.build().create(UnsplashApi::class.java)
        }


    }
}