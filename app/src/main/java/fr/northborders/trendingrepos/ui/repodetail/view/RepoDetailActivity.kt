package fr.northborders.trendingrepos.ui.repodetail.view

import android.content.Context
import android.content.Intent
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import fr.northborders.mvp.BaseFragmentActivity
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.ui.model.RepoViewModel

class RepoDetailActivity : BaseFragmentActivity() {
    override val fragmentInstance: Fragment
        get() = RepoDetailFragment.newInstance()

    override val layoutResId: Int
        @LayoutRes get() = R.layout.activity_base

    companion object {

        private val BUNDLE_EXTRA_REPO = "bundle_extra_repo"

        fun newIntent(context: Context, repo: RepoViewModel): Intent {
            val intent = Intent(context, RepoDetailActivity::class.java)
            return intent
        }
    }
}