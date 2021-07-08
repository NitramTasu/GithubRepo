package com.example.githubrepo.data.model

import com.google.gson.annotations.SerializedName

class GHResponse(
    @SerializedName("items") val items: List<GHRepository>
)