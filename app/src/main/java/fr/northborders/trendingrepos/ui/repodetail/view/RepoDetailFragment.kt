package fr.northborders.trendingrepos.ui.repodetail.view

import android.os.Bundle
import android.util.Log
import android.view.View
import fr.northborders.mvp.BaseFragment
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.repodetail.RepoDetailPresenter
import fr.northborders.trendingrepos.ui.repodetail.RepoDetailUi
import javax.inject.Inject

class RepoDetailFragment: BaseFragment(), RepoDetailUi {

    override val layoutResId: Int
        get() = R.layout.fragment_repo_detail

    @Inject lateinit var presenter: RepoDetailPresenter

    companion object {
        fun newInstance() = RepoDetailFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
    }

    override fun initPresenter() {
        super.initPresenter()
        presenter.ui = this
        presenter.start()
    }

    override fun initFragment(view: View) {
        initViews(view)
    }

    override fun showLoading() {
        Log.d(RepoDetailFragment::class.simpleName, "show loading")
    }

    override fun hideLoading() {
        Log.d(RepoDetailFragment::class.simpleName, "hide loading")
    }

    fun initViews(view: View) {

    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
    }
}