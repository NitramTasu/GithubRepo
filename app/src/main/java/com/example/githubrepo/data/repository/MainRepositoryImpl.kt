package com.example.githubrepo.data.repository

import com.example.githubrepo.data.api.GithubService
import com.example.githubrepo.data.datasource.net.RemoteDataSource
import com.example.githubrepo.data.mapper.GHRepositoryDomainMapper
import com.example.githubrepo.domain.mapper.PresentationMapper
import com.example.githubrepo.domain.model.GHRepository
import com.example.githubrepo.domain.repository.MainRepository
import com.example.githubrepo.presentation.model.RepoPresentationModel

class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource) : MainRepository {
    private val mapper: PresentationMapper = PresentationMapper()

    override suspend fun getGHRepositories(): List<RepoPresentationModel> {
        return mapper.map(remoteDataSource.getRepositories())
    }

}