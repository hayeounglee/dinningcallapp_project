package com.example.dinningcallapp_project

import com.example.dinningcallapp_project.model.RoomResponses
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface LoginService {

    @POST("/createuser")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
    ):Call<RoomResponses>


}
