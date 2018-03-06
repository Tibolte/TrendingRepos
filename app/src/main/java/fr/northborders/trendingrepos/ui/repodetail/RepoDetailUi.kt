package fr.northborders.trendingrepos.ui.repodetail

import fr.northborders.mvp.BasePresenterLoader

interface RepoDetailUi : BasePresenterLoader.Ui {
    override fun showLoading()

    override fun hideLoading()
}