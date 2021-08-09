package com.android.mvvmexample.data.network

import com.android.mvvmexample.data.model.PhraseModel
import retrofit2.Response
import retrofit2.http.GET

interface PhraseApiClient {
    @GET("/.json")
    suspend fun getAllPhrases(): Response<List<PhraseModel>>
}