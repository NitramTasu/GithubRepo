package com.example.githubrepo.presentation.model

data class RepoPresentationModel (
    val repoName: String = "",
    val stars: Int = 0,
    val forks: Int = 0,
    val ownerAvatar: String = "",
    val ownerName: String = "")