package com.example.dinningcallapp_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.dinningcallapp_project.databinding.ActivitySign1Binding
import com.example.dinningcallapp_project.model.RoomResponses
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Sign1Activity: AppCompatActivity() {

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
        val etEmail: AppCompatEditText = findViewById(R.id.et_email)
        val etPassword: AppCompatEditText = findViewById(R.id.et_password)
        //val efConfirm: app

        binding?.next?.setOnClickListener {
            if (!etEmail.text.toString().isEmpty() && !etPassword.text.toString().isEmpty()){
                Toast.makeText(this,"email 또는 password 입력하세요",Toast.LENGTH_SHORT).show()
            }else if(etPassword.text.toString() != binding?.etConfirmPassword.toString()){
                Toast.makeText(this,"password가 다릅니다",Toast.LENGTH_SHORT).show()
            }
            else{ //user가 올바른 정보를 입력시

                val retrofit = Retrofit.Builder()
                    .baseUrl("@string/baseUrl")
                    .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
                    .build() //레트로핏 구현체 완성!

                val service: LoginService =
                    retrofit.create<LoginService>(LoginService::class.java)


                val listCall: Call<RoomResponses> = service.createUser(
                    binding?.etEmail, binding?.etPassword
                )

                listCall.enqueue(object : Callback<RoomResponses>{
                    override fun onResponse(
                        call: Call<RoomResponses>,
                        roomResponses: retrofit2.Response<RoomResponses>
                    ) {
                        if(roomResponses.isSuccessful){
                            val list : RoomResponses = roomResponses.body()
                            Log.i("Response Result", "$list")
                        }
                    }

                    override fun onFailure(call: Call<RoomResponses>, t: Throwable) {
                       Log.e("Errorrrr", t!!.message.toString())
                    }

                })



                val intent = Intent(this,Roomlist::class.java)
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