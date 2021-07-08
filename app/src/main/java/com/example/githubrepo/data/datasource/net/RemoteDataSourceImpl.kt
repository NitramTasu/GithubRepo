package com.example.githubrepo.data.datasource.net

import com.example.githubrepo.data.api.GithubService
import com.example.githubrepo.data.mapper.GHRepositoryDomainMapper
import com.example.githubrepo.domain.model.GHRepository

class RemoteDataSourceImpl(
    private val api: GithubService
) : RemoteDataSource {
    private val mapper: GHRepositoryDomainMapper = GHRepositoryDomainMapper()

    override suspend fun getRepositories(): List<GHRepository> {
        return mapper.map(api.getRepositoriesByLanguageSortByStars("language:kotlin", "starts", 1))
    }
}