package com.example.githubrepo.data.model

import com.google.gson.annotations.SerializedName

data class GHRepository(
    @SerializedName("name") val name: String = "",
    @SerializedName("owner") val owner: Owner,
    @SerializedName("forks_count") val forks_count: Int = 0,
    @SerializedName("stargazers_count") val stargazers_count: Int = 0
)