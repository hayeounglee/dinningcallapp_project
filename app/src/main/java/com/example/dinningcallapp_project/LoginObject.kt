package com.example.dinningcallapp_project
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST


data class LoginObject(
    @SerializedName("id")val id:Int,
    @SerializedName("password") val password:String
)

interface LoginService {
    @POST("/login")
    fun login(@Body params: LoginObject): Call<LoginObject>

}