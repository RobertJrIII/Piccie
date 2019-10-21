package dev.rj3.app.piccie.retrofit

import dev.rj3.app.piccie.Client_ID
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object UnsplashApiInstance {


    fun getInstance(): UnsplashApi {
        val okhttpBuilder = OkHttpClient.Builder()

        okhttpBuilder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val request = chain.request()

                val newRequest = request.newBuilder().addHeader(
                    "Authorization",
                    "Client-ID $Client_ID"
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