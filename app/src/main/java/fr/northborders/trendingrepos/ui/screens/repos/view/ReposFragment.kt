package fr.northborders.trendingrepos.ui.screens.repos.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.northborders.basecomponents.BaseFragment
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.model.ReposViewModel
import fr.northborders.trendingrepos.ui.screens.repos.RecyclerScrollMoreListener
import fr.northborders.trendingrepos.ui.screens.repos.ReposAdapter
import fr.northborders.trendingrepos.ui.screens.repos.ReposPresenter
import fr.northborders.trendingrepos.ui.screens.repos.ReposUi
import javax.inject.Inject

class ReposFragment: BaseFragment(), ReposUi, RecyclerScrollMoreListener.OnLoadMoreListener {
    override val layoutResId: Int
        get() = R.layout.fragment_repos

    @Inject
    lateinit var presenter: ReposPresenter

    lateinit var adapter: ReposAdapter
    var progressbar: ProgressBar? = null

    private lateinit var reposViewModel: ReposViewModel

    companion object {
        fun newInstance() = ReposFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        reposViewModel = ViewModelProvider(this)[ReposViewModel::class.java]
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
        reposViewModel.addRepos(reposList)
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
        supportActionBar.title = getString(R.string.android_trending_repos)
    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
    }

    fun initAdapter() {
        adapter = ReposAdapter()
//        if (adapter.itemCount > 0) {
//
//        }
    }

    fun initRecycler(view: View) {
        val recyclerview = view.findViewById<RecyclerView>(R.id.list_repos)
        val layoutManager = LinearLayoutManager(activity)
        recyclerview.layoutManager = layoutManager
        recyclerview.addOnScrollListener(RecyclerScrollMoreListener(layoutManager, this))
        recyclerview.adapter = adapter
    }
}