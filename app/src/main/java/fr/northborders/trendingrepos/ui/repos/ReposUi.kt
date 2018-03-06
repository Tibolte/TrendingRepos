package fr.northborders.trendingrepos.ui.repos

import fr.northborders.mvp.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoViewModel

interface ReposUi : BasePresenterLoader.Ui {
    fun showRepos(reposList: List<RepoViewModel>)

    fun showEmptyMessage()

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}
