package com.example.githubrepo.domain.usecase

import com.example.githubrepo.domain.repository.MainRepository

class GetGHRepositories (private val repository: MainRepository) {
    suspend operator fun invoke() = repository.getGHRepositories()
}