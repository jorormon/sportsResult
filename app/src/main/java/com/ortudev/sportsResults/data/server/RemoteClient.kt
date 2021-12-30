package com.ortudev.sportsResults.data.server

import com.ortudev.sportsResults.BuildConfig
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RemoteClient {

    fun <Api> buildApi(
        api: Class<Api>,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(ServerConfig.baseUrl)
            .client(getRetrofitClientAuth())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getRetrofitClientAuth(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                manageHeadersLogin(chain)
            }.also { client ->
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build()
    }

    private fun manageHeadersLogin(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().also {
            it.addHeader("x-rapidapi-host", "api-formula-1.p.rapidapi.com")
            it.addHeader("x-rapidapi-key", ServerConfig.apiKey)
        }.build()
        return chain.proceed(request)
    }
}


