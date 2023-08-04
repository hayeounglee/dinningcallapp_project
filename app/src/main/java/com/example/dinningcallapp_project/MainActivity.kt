package com.example.dinningcallapp_project
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // added setContentView function
        setContentView(R.layout.activity_main)

        val buttonStart: Button = findViewById(R.id.sign)

        buttonStart.setOnClickListener {
            // 버튼 클릭하면 로그인 되게!


            val retrofit= Retrofit.Builder()
                .baseUrl("@string/baseUrl")
                .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
                .build() //레트로핏 구현체 완성!

            val loginService=retrofit.create(LoginService::class.java) //retrofit객체 만듦!
            loginService.login(LoginObject(1, password = "aaaa"))

            val intent = Intent(this,Sign1::class.java)
            startActivity(intent)
        }


    }
}