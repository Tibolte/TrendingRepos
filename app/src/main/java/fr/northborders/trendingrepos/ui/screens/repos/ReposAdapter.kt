package fr.northborders.trendingrepos.ui.screens.repos

import android.support.v7.util.DiffUtil
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
        val oldList = this.reposList
        val newList = oldList + reposList
        this.reposList = newList
        val result = DiffUtil.calculateDiff(Callback(oldList, newList))
        result.dispatchUpdatesTo(this)
    }

    private class Callback(
        val old: List<RepoViewModel>,
        val new: List<RepoViewModel>
    ) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition].id == new[newItemPosition].id
        }

        override fun getOldListSize(): Int {
            return old.size
        }

        override fun getNewListSize(): Int {
            return new.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition].id == new[newItemPosition].id
        }
    }
}