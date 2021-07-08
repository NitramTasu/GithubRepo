package com.example.githubrepo.domain.repository

import com.example.githubrepo.presentation.model.RepoPresentationModel

interface MainRepository {
    suspend fun getGHRepositories(): List<RepoPresentationModel>
}