package com.example.pe_assignment


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity(), LoadingImplementation {
    override fun onFinishedLoading() {
        loadingAnimation.stopAnimation(R.layout.activity_loading)
    }

    private lateinit var loadingAnimation : LoadingAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingAnimation = LoadingAnimation(this, "loading.json")

        loadingAnimation.playAnimation(true)
        LoadingAsync(this).execute()
    }
}