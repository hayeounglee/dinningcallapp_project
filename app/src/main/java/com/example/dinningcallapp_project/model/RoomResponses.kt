package com.example.dinningcallapp_project.model

import java.io.Serializable

data class RoomResponses(

    val member: Member,
    val memberlist: List<Member>,
    val room : Room

):Serializable
