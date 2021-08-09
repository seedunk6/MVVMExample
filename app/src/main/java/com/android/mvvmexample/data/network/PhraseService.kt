package com.android.mvvmexample.data.network

import com.android.mvvmexample.data.model.PhraseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PhraseService @Inject constructor(
    private val api:PhraseApiClient) {
    suspend fun getPhrases(): List<PhraseModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPhrases()
            response.body() ?: emptyList()
        }
    }
}