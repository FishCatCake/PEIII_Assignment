package com.example.pe_assignment.loading


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.pe_assignment.Login.LoginActivity
import com.example.pe_assignment.R

class LoadingActivity : AppCompatActivity(), LoadingImplementation {
    override fun onFinishedLoading() {
        loadingAnimation.stopAnimation(R.layout.activity_loading)
    }

    private lateinit var loadingAnimation : LoadingAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadingAnimation = LoadingAnimation(this, "loading.json")

        loadingAnimation.playAnimation(true)
        LoadingAsync(this).execute()

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@LoadingActivity, LoginActivity::class.java)
            startActivity(i)
            finish()
        }, 4000) // delay for 3000 milliseconds or 3 seconds
    }
}