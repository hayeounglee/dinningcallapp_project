package com.example.dinningcallapp_project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Roomlist : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roomlist)

        val buttonStart: Button = findViewById(R.id.add_room)
        val buttonStart2: Button = findViewById(R.id.btn_join)
        //val etName: AppCompatEditText = findViewById(R.id.et_search)

        /*if (etName.text.toString().isEmpty()) {
            Toast.makeText(this, "You can Search", Toast.LENGTH_SHORT).show()
        }*/

        buttonStart.setOnClickListener {
            val intent = Intent(this, Sign2::class.java) // 나중에 바꾸기
            startActivity(intent)
        }
        buttonStart2.setOnClickListener {
            val intent = Intent(this, Sign2::class.java) // 나중에 바꾸기
            startActivity(intent)
        }
    }
    }