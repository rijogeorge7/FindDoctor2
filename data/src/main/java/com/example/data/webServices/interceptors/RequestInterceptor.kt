package com.example.data.webServices.interceptors

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("user_key", BuildConfig.BETTER_DOCTOR_API_KEY)
                .build()

        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
