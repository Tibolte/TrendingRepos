package fr.northborders.trendingrepos.ui

import fr.northborders.trendingrepos.ui.base.BasePresenterLoader

interface ReposUi : BasePresenterLoader.Ui {
    fun showRepos(reposList: List<RepoViewModel>)

    fun showEmptyMessage()

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}
