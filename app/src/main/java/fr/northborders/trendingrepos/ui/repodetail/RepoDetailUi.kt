package fr.northborders.trendingrepos.ui.repodetail

import fr.northborders.mvp.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel

interface RepoDetailUi : BasePresenterLoader.Ui {

    fun readmeLoaded(repoContentViewModel: RepoContentViewModel)

    fun showMarkdown(data: String)

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}