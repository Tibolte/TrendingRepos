package fr.northborders.trendingrepos.ui.repos.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.repos.RecyclerScrollMoreListener
import fr.northborders.trendingrepos.ui.repos.ReposAdapter
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.repos.ReposPresenter
import fr.northborders.trendingrepos.ui.repos.ReposUi
import fr.northborders.mvp.BaseFragment
import javax.inject.Inject

class ReposFragment : BaseFragment(), ReposUi, RecyclerScrollMoreListener.OnLoadMoreListener {

    override val layoutResId: Int
        get() = R.layout.fragment_repos

    @Inject lateinit var presenter: ReposPresenter

    lateinit var adapter: ReposAdapter
    var progressbar: ProgressBar? = null

    companion object {
        fun newInstance() = ReposFragment()
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
        initAdapter()
        initRecycler(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.terminate()
    }

    override fun showRepos(reposList: List<RepoViewModel>) {
        Log.d(ReposFragment::class.simpleName, "show repos")
        adapter.addReposList(reposList)
    }

    override fun showEmptyMessage() {
        Log.d(ReposFragment::class.simpleName, "show empty message")
    }

    override fun showErrorMessage() {
        Log.d(ReposFragment::class.simpleName, "show error message")
    }

    override fun showLoading() {
        Log.d(ReposFragment::class.simpleName, "show loading")
        progressbar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        Log.d(ReposFragment::class.simpleName, "hide loading")
        progressbar?.visibility = View.GONE
    }

    override fun onLoadMore(page: Int, total: Int) {
        Log.d(ReposFragment::class.simpleName, String.format("Load more with page:%d and total:%d", page, total))
        presenter.loadMore(page)
    }

    fun initViews(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        progressbar = view.findViewById(R.id.progressbar)
        setSupportActionBarOnFragment(toolbar)
        supportActionBar?.title = getString(R.string.android_trending_repos)
    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
    }

    fun initAdapter() {
        adapter = ReposAdapter()
    }

    fun initRecycler(view: View) {
        val recyclerview = view.findViewById<RecyclerView>(R.id.list_repos)
        val layoutManager = LinearLayoutManager(activity)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter
        recyclerview.addOnScrollListener(RecyclerScrollMoreListener(layoutManager, this))
    }
}