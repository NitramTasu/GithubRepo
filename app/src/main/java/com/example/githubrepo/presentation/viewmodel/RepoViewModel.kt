package com.example.githubrepo.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.example.githubrepo.domain.usecase.GetGHRepositories
import com.example.githubrepo.presentation.model.RepoPresentationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RepoViewModel(
    private val userCase: GetGHRepositories
): ViewModel(){

    fun execute(): MutableLiveData<List<RepoPresentationModel>?> {
        val liveData = MutableLiveData<List<RepoPresentationModel>?>()
        viewModelScope.launch(Dispatchers.IO){
            runCatching {
                liveData.postValue(userCase())
            }.onSuccess {
                Log.i("Sucesso", "Sucesso!!")
            }.onFailure {
                Log.i("Falhou", "Falhou!!")
            }
        }
        return liveData
    }

}