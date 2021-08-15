package fr.northborders.trendingrepos.ui.screens.repodetail

import fr.northborders.basecomponents.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel

interface RepoDetailUi : BasePresenterLoader.Ui {

    fun readmeLoaded(repoContentViewModel: RepoContentViewModel)

    fun showMarkdown(data: String)

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}