package com.example.danielbassett.charactersheet.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.danielbassett.charactersheet.R

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun onCreateCharacterClicked(view: View){
        val createCharacterIntent = Intent(this, CreateCharacterName::class.java)
        startActivity(createCharacterIntent)
    }
}
