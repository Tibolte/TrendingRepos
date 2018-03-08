package fr.northborders.trendingrepos.ui.screens.repodetail.view

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Base64
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.northborders.basecomponents.BaseFragment
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.TrendingReposApplication
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.screens.repodetail.RepoDetailPresenter
import fr.northborders.trendingrepos.ui.screens.repodetail.RepoDetailUi
import javax.inject.Inject

class RepoDetailFragment: BaseFragment(), RepoDetailUi {

    override val layoutResId: Int
        get() = R.layout.fragment_repo_detail

    var repo: RepoViewModel? = null
    var progressbar: ProgressBar? = null
    lateinit var webView: WebView
    lateinit var errorView: TextView
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
            presenter.loadReadMe(repo?.owner?.login, repo?.name)
        }

        presenter.ui = this
        presenter.start()
    }

    override fun initFragment(view: View) {
        initViews(view)
    }

    override fun showLoading() {
        Log.d(RepoDetailFragment::class.simpleName, "show loading")
        progressbar?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        Log.d(RepoDetailFragment::class.simpleName, "hide loading")
        progressbar?.visibility = View.GONE
    }

    override fun readmeLoaded(repoContentViewModel: RepoContentViewModel) {
        Log.d(RepoDetailFragment::class.simpleName, "show readme")
        val markdown = String(Base64.decode(repoContentViewModel.content, Base64.DEFAULT))
        presenter.markdown(markdown)
    }

    override fun showMarkdown(data: String) {
        Log.d(RepoDetailFragment::class.simpleName, "show raw readme")
        val cssFile = "file:///android_asset/markdown_css_theme/classic.css"
        val html = "<link rel='stylesheet' type='text/css' href='$cssFile' />$data"
        webView.loadDataWithBaseURL(null, html,"text/html", "UTF-8", null)
    }

    override fun showErrorMessage() {
        Log.d(RepoDetailFragment::class.simpleName, "show error message")
        errorView.visibility = View.VISIBLE
    }

    fun initDagger() {
        TrendingReposApplication.appComponent.inject(this)
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

        progressbar = view.findViewById(R.id.loadingView)

        webView = view.findViewById<WebView>(R.id.repo_detail)
        webView.webViewClient = DefaultWebViewClient()

        errorView = view.findViewById(R.id.errorView)
    }

    open class DefaultWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            return true
        }
    }
}