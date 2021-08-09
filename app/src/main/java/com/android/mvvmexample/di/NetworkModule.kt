package com.android.mvvmexample.di

import com.android.mvvmexample.data.network.PhraseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl:String = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePhraseApiClient(retrofit: Retrofit): PhraseApiClient {
        return retrofit.create(PhraseApiClient::class.java)
    }
}