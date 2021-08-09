package com.android.mvvmexample.data

import com.android.mvvmexample.data.model.PhraseModel
import com.android.mvvmexample.data.model.PhraseProvider
import com.android.mvvmexample.data.network.PhraseService
import javax.inject.Inject

class PhraseRepository @Inject constructor(
    private val api: PhraseService,
    private val phraseProvider: PhraseProvider){

    suspend fun getAllPhrases():List<PhraseModel>{
        val response = api.getPhrases()
        phraseProvider.phrases = response
        return response
    }

}