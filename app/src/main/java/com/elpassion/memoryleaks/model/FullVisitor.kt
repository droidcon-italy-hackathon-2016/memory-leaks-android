package com.elpassion.memoryleaks.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FullVisitor(val name: String,
                  val relation: String,
                  @SerializedName("photo_url") val photoUrl: String) : Serializable