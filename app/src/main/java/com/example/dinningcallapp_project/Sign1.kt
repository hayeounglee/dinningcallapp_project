package com.example.dinningcallapp_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.dinningcallapp_project.databinding.ActivitySign1Binding

class Sign1: AppCompatActivity() {

    //binding 변수 선언하기
    private var binding:ActivitySign1Binding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding 선언하기
        binding = ActivitySign1Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Action bar(tool bar 만들기)
        setSupportActionBar(binding?.toolbarExercise)
        getSupportActionBar()?.setTitle("Dining room");

        //val buttonStart: Button = findViewById(R.id.btn_next) -> bindging해서 이제 이런거 안해도 됨
        val etName: AppCompatEditText = findViewById(R.id.et_id)

        binding?.next?.setOnClickListener {
            if (etName.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,Sign2::class.java)
                startActivity(intent)
            }
        }

        //tool bar에서 뒤로가기
        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    //뷰 바인딩 destory
    override fun onDestroy() {
        super.onDestroy()
        //Todo 4: TO avoid memory leak we unassign the binding once the activity is destroyed
        binding = null
    }

}