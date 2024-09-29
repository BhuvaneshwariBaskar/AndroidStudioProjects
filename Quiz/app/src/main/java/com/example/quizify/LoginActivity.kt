package com.example.quizify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizify.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)
        binding.dont.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        firebaseAuth=FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,"Login Successfull", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"User doesn't exist", Toast.LENGTH_SHORT).show()
//                    Log.d("z", "onComplete: Failed=" + it.getException().getMessage())
                }
            }
        }
        else{
            Toast.makeText(this,"Please fill the field", Toast.LENGTH_SHORT).show()
        }

        }
    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null){
//            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
//            startActivity(intent)
            Toast.makeText(this,"Please fill the field", Toast.LENGTH_SHORT).show()
        }
    }
}


