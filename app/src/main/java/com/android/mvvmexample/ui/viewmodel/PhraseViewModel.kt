package com.android.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mvvmexample.data.model.PhraseModel
import com.android.mvvmexample.domain.GetPhrasesUseCase
import com.android.mvvmexample.domain.GetRandomPhraseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhraseViewModel @Inject constructor(
    private val getPhrasesUseCase: GetPhrasesUseCase,
    private val getRandomPhraseUseCase: GetRandomPhraseUseCase
): ViewModel() {

    val phraseModel = MutableLiveData<PhraseModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPhrasesUseCase()
            if(!result.isNullOrEmpty()){
                phraseModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun random() {
        isLoading.postValue(true)
        val phrase = getRandomPhraseUseCase()
        if(phrase != null){
            phraseModel.postValue(phrase)
        }
        isLoading.postValue(false)
    }

}