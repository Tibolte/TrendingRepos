package fr.northborders.trendingrepos.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.ui.model.RepoViewModel

class ReposAdapter: RecyclerView.Adapter<RepoViewHolder>() {

    private var reposList: List<RepoViewModel>

    init {
        reposList = ArrayList<RepoViewModel>()
    }

    override fun getItemCount() = reposList.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = reposList[position]
        holder.renderRepo(repo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RepoViewHolder(layoutInflater.inflate(R.layout.item_repo, parent, false))
    }

    fun addReposList(reposList: List<RepoViewModel>) {
        this.reposList = reposList
    }
}