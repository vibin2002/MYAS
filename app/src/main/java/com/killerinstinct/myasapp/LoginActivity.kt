package com.killerinstinct.myasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.killerinstinct.myasapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dontHavAcc.setOnClickListener {
            startActivity(Intent(this, SignupPage::class.java))
            finish()
        }

        binding.loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.emailInLogin.text.toString(),
                binding.passwordInLogin.text.toString()
            ).addOnSuccessListener { 
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, "Oops! Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}