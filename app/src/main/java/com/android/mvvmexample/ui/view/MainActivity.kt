package com.android.mvvmexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.android.mvvmexample.databinding.ActivityMainBinding
import com.android.mvvmexample.ui.viewmodel.PhraseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val phraseViewModel: PhraseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phraseViewModel.onCreate()

        callObserver()

        callLoading()

        clickOnTheScreen()
    }

    private fun callObserver(){
        phraseViewModel.phraseModel.observe(this, Observer {
            binding.tvPhrase.text = it.phrase
            binding.tvAuthor.text = it.author

        })
    }

    private fun callLoading() {
        phraseViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
    }

    private fun clickOnTheScreen(){
        binding.constraintLayout.setOnClickListener { phraseViewModel.random() }
    }
}