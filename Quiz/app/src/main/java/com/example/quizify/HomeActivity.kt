package com.example.quizify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizify.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)
        binding.cardView1.setOnClickListener {
            val intent = Intent(this@HomeActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.cardView2.setOnClickListener {
            val intent = Intent(this@HomeActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.cardView3.setOnClickListener {
            val intent = Intent(this@HomeActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}