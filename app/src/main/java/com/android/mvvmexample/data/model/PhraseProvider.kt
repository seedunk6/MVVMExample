package com.android.mvvmexample.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhraseProvider @Inject constructor() {
    var phrases:List<PhraseModel> = emptyList()
}