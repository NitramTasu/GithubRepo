package com.example.githubrepo.domain.mapper

import com.example.githubrepo.domain.model.GHRepository
import com.example.githubrepo.presentation.model.RepoPresentationModel
import com.example.githubrepo.utils.Mapper

class PresentationMapper: Mapper<List<GHRepository>, List<RepoPresentationModel>> {

    override fun map(repoGH: List<GHRepository>): List<RepoPresentationModel>{
        val repoPresentationModel = ArrayList<RepoPresentationModel>()

        for (item in repoGH) {
            repoPresentationModel.add(
                RepoPresentationModel(
                    repoName = item.repoName,
                    stars = item.stars,
                    forks = item.forks,
                    ownerAvatar = item.ownerPhoto,
                    ownerName = item.ownerName
                )
            )
        }
        return repoPresentationModel
    }
}