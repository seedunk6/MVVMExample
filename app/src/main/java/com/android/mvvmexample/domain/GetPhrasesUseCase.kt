package com.android.mvvmexample.domain

import com.android.mvvmexample.data.PhraseRepository
import javax.inject.Inject

class GetPhrasesUseCase @Inject constructor(
    private val repository: PhraseRepository){
    suspend operator fun invoke() = repository.getAllPhrases()
}