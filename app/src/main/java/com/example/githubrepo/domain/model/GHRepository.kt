package com.example.githubrepo.domain.model

data class GHRepository(
    val repoName: String = "",
    val stars: Int = 0,
    val forks: Int = 0,
    val ownerPhoto: String = "",
    val ownerName: String = ""
)