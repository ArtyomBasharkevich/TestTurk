package com.test.turkcelltest.presentation.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.turkcelltest.BuildConfig
import com.test.turkcelltest.data.network.IRestApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class RestModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideRestApi(retrofit: Retrofit): IRestApi = retrofit.create(IRestApi::class.java)

        @JvmStatic
        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .client(okHttpClient)
                .build()

        @JvmStatic
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(getLogging())
                .build()

        private fun getLogging(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        }

        private fun getGson(): Gson = GsonBuilder().setPrettyPrinting().create()
    }
}