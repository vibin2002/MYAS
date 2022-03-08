package com.killerinstinct.myasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.killerinstinct.myasapp.databinding.ActivitySignupPageBinding

class SignupPage : AppCompatActivity() {

    lateinit var binding: ActivitySignupPageBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.spEmail.text.toString(),
                binding.spPassword.text.toString()
            ).addOnSuccessListener {
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,  "Error", Toast.LENGTH_SHORT).show()
            }
        }

    }
}