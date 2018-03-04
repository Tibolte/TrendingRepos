package fr.northborders.trendingrepos.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.RepoViewModel
import fr.northborders.trendingrepos.ui.ReposPresenter
import fr.northborders.trendingrepos.ui.ReposUi
import fr.northborders.trendingrepos.ui.base.BaseFragment
import javax.inject.Inject

class ReposFragment : BaseFragment(), ReposUi {

    override val layoutResId: Int
        get() = R.layout.repos_fragment

    @Inject lateinit var presenter: ReposPresenter

    companion object {
        fun newInstance() = ReposFragment()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        Log.d("test", "test")
    }

    override fun showRepos(reposList: List<RepoViewModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
    }
}