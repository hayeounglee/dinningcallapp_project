package com.example.dinningcallapp_project
import com.google.gson.annotations.SerializedName
import retrofit2.Call



data class LoginObject(
    @SerializedName("id")val id:Int,
    @SerializedName("password") val password:String
)

interface LoginService {
    @POST("/login")
    fun login(@Body params: LoginObject): Call<LoginObject>

}