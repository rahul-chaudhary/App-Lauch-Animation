package com.example.applauchloader

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applauchloader.databinding.ActivityMainBinding
import com.example.applauchloader.databinding.TempLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding
//    private lateinit var mbinding: TempLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.loadingAnimView.startAnimation()

    }
}