package com.elpassion.memoryleaks.model

import com.google.gson.annotations.SerializedName

class Elder(val id: String, @SerializedName("photo_url") val photoUrl: String)