package fr.northborders.trendingrepos.ui.screens.repos

import fr.northborders.basecomponents.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoViewModel

interface ReposUi : BasePresenterLoader.Ui {
    fun showRepos(reposList: List<RepoViewModel>)

    fun showEmptyMessage()

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}