package com.example.githubrepo.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.R
import com.example.githubrepo.presentation.adapter.RepoAdapter
import com.example.githubrepo.presentation.model.RepoPresentationModel
import com.example.githubrepo.presentation.viewmodel.RepoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val repoViewModel: RepoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.repo_list)
        recyclerView.layoutManager = LinearLayoutManager(this);

        val repoObserver = Observer<List<RepoPresentationModel>?> { repos ->
            val adapter = RepoAdapter(repos)
            recyclerView.adapter = adapter
        }
        repoViewModel.execute().observe(this, repoObserver)
    }
}