package fr.northborders.trendingrepos.ui.repodetail

import fr.northborders.mvp.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel

interface RepoDetailUi : BasePresenterLoader.Ui {

    fun showReadMe(repoContentViewModel: RepoContentViewModel)

    fun showRawReadMe(data: String)

    fun showErrorMessage()

    override fun showLoading()

    override fun hideLoading()
}