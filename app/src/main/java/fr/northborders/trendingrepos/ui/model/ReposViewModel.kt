package fr.northborders.trendingrepos.ui.model

import androidx.lifecycle.ViewModel

class ReposViewModel(): ViewModel() {
    private var reposList: MutableList<RepoViewModel> = ArrayList()

    fun addRepos(repos: List<RepoViewModel>) {
        for (item in repos) {
            if (this.reposList.any { item.id == it.id }) {
                continue
            }
            this.reposList.add(item)
        }
    }
}