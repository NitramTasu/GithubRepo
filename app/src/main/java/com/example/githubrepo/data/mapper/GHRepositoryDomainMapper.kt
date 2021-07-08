package com.example.githubrepo.data.mapper

import com.example.githubrepo.data.model.GHResponse
import com.example.githubrepo.domain.model.GHRepository

import com.example.githubrepo.utils.Mapper

class GHRepositoryDomainMapper : Mapper<GHResponse, List<GHRepository>> {
    override fun map(ghResponse: GHResponse): List<GHRepository> {
        val ghRepositories = ArrayList<GHRepository>()

        for (item in ghResponse.items) {
            ghRepositories.add(
                GHRepository(
                    item.name,
                    item.forks_count,
                    item.stargazers_count,
                    item.owner.avatar_url,
                    item.owner.login
                )
            )
        }
        return ghRepositories
    }
}