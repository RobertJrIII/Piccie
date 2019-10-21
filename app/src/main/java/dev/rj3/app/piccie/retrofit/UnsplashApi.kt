package dev.rj3.app.piccie.retrofit

import dev.rj3.app.piccie.Client_ID
import dev.rj3.app.piccie.models.UnsplashImage
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashApi {

    @Headers("Accept-Version: v1")
    @GET("photos")
    fun getPhotos(): Call<List<UnsplashImage>>





}