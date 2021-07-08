package com.example.githubrepo.data.datasource.net

import com.example.githubrepo.domain.model.GHRepository

interface RemoteDataSource {
    suspend fun getRepositories(): List<GHRepository>
}