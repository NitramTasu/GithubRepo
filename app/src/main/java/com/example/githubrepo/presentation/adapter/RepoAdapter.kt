package com.example.githubrepo.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepo.R
import com.example.githubrepo.presentation.model.RepoPresentationModel

class RepoAdapter(
    private val reposList: List<RepoPresentationModel>
) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    class ViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
        val repoNameTv: TextView = view.findViewById(R.id.repo_name_tv)
        val starsTv: TextView = view.findViewById(R.id.stars_tv)
        val forksTv: TextView = view.findViewById(R.id.forks_tv)
        val ownerNameTv: TextView = view.findViewById(R.id.owner_name_tv)
        val ownerIv: ImageView = view.findViewById(R.id.owner_iv)
        val context: Context = context

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.repo_item, viewGroup, false)

        return ViewHolder(view, viewGroup.context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder){
            with(reposList[position]){
                viewHolder.repoNameTv.text = context.getString(R.string.repo_name_label).format(reposList[position].repoName)
                viewHolder.starsTv.text = context.getString(R.string.starts_label).format(reposList[position].stars.toString())
                viewHolder.forksTv.text = context.getString(R.string.forks_label).format(reposList[position].forks.toString())
                viewHolder.ownerNameTv.text = context.getString(R.string.owner_label).format(reposList[position].ownerName)
                Glide.with(viewHolder.context).load(reposList[position].ownerAvatar).into(viewHolder.ownerIv);
            }
        }

    }

    override fun getItemCount() = reposList.size

}