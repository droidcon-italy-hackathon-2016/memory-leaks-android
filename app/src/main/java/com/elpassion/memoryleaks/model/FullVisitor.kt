package com.elpassion.memoryleaks.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FullVisitor(val name: String,
                  val relation: String,
                  @SerializedName("photo_urls") val photoUrls: List<String>) : Serializable