package com.mcs.lmmtcodechallenge.injectables

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientSingleton {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.themoviedb.org/"

    //private fun createLoggerClient() = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)).build()

    val retrofitInstance: Retrofit? get(){
        if(retrofit == null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(createLoggerClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }
}