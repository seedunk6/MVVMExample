package com.android.mvvmexample.domain

import com.android.mvvmexample.data.model.PhraseModel
import com.android.mvvmexample.data.model.PhraseProvider
import javax.inject.Inject

class GetRandomPhraseUseCase @Inject constructor(
    private val phraseProvider: PhraseProvider){
    operator fun invoke(): PhraseModel?{
        val phrases = phraseProvider.phrases
        if(!phrases.isNullOrEmpty()){
            val randomNumber = (phrases.indices).random()
            return phrases[randomNumber]
        }
        return null
    }
}