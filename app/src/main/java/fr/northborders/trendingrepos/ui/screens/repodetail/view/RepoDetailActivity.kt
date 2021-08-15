package fr.northborders.trendingrepos.ui.screens.repodetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import fr.northborders.basecomponents.BaseFragmentActivity
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import java.io.Serializable

class RepoDetailActivity : BaseFragmentActivity() {
    override val fragmentInstance: Fragment
        get() = RepoDetailFragment.newInstance()

    override val layoutResId: Int
        @LayoutRes get() = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        if (intent.hasExtra(BUNDLE_EXTRA_REPO)) {
            val repo: Serializable? = intent.getSerializableExtra(BUNDLE_EXTRA_REPO)
            replaceFragment(RepoDetailFragment.newInstance(repo as RepoViewModel))
        }
    }

    companion object {

        private val BUNDLE_EXTRA_REPO = "bundle_extra_repo"

        fun newIntent(context: Context, repo: RepoViewModel): Intent {
            val intent = Intent(context, RepoDetailActivity::class.java)
            intent.putExtra(BUNDLE_EXTRA_REPO, repo)
            return intent
        }
    }
}