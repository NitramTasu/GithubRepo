package com.example.githubrepo.data.api

import com.example.githubrepo.data.model.GHResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("/search/repositories")
    suspend fun getRepositoriesByLanguageSortByStars(
        @Query("q") language: String,
        @Query("sort") orderBy: String,
        @Query("page") page: Int
    ): GHResponse
}