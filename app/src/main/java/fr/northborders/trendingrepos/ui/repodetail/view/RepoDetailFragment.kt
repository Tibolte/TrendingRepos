package fr.northborders.trendingrepos.ui.repodetail.view

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.northborders.mvp.BaseFragment
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.repodetail.RepoDetailPresenter
import fr.northborders.trendingrepos.ui.repodetail.RepoDetailUi
import javax.inject.Inject

class RepoDetailFragment: BaseFragment(), RepoDetailUi {

    override val layoutResId: Int
        get() = R.layout.fragment_repo_detail

    var repo: RepoViewModel? = null
    @Inject lateinit var presenter: RepoDetailPresenter

    companion object {
        val BUNDLE_EXTRA_REPO = "bundle_extra_repo"

        fun newInstance() = RepoDetailFragment()

        fun newInstance(repoViewModel: RepoViewModel): RepoDetailFragment {
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_EXTRA_REPO, repoViewModel)
            val fragment = newInstance()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
    }

    override fun initPresenter() {
        super.initPresenter()

        if (arguments?.getSerializable(BUNDLE_EXTRA_REPO) != null) {
            repo = arguments?.getSerializable(BUNDLE_EXTRA_REPO) as RepoViewModel?
        }

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
        if (repo == null) {
            return
        }

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBarOnFragment(toolbar)
        supportActionBar?.title = repo?.name

        view.findViewById<TextView>(R.id.repo_name).text = repo?.name
        view.findViewById<TextView>(R.id.repo_desc).text = repo?.description
        view.findViewById<TextView>(R.id.repo_stars).text = String.format(getString(R.string.title_star), repo?.starGazersCount)
        view.findViewById<TextView>(R.id.repo_fork).text = String.format(getString(R.string.title_fork), repo?.forksCount)
        Picasso.with(context).load(repo?.owner?.avatarUrl).into(view.findViewById<ImageView>(R.id.repo_owner_avatar))
    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
    }
}