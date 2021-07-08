package com.example.githubrepo.di

import com.example.githubrepo.data.api.GithubService
import com.example.githubrepo.data.api.NetworkClient
import com.example.githubrepo.data.datasource.net.RemoteDataSource
import com.example.githubrepo.data.datasource.net.RemoteDataSourceImpl
import com.example.githubrepo.data.repository.MainRepositoryImpl
import com.example.githubrepo.domain.repository.MainRepository
import com.example.githubrepo.domain.usecase.GetGHRepositories
import com.example.githubrepo.presentation.viewmodel.RepoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetGHRepositories(repository = get()) }
}

val dataModules = module {
    factory<RemoteDataSource> { RemoteDataSourceImpl(api = get()) }
    factory<MainRepository> { MainRepositoryImpl(remoteDataSource = get()) }
}

val networkModules = module {
    single { NetworkClient() }
    factory { get<NetworkClient>().create(GithubService::class.java) }
}

val presentationModules = module {
    viewModel{RepoViewModel(userCase = get())}
}



