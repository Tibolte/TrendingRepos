package fr.northborders.trendingrepos.ui.view

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import fr.northborders.trendingrepos.R
import fr.northborders.trendingrepos.ui.base.BaseFragmentActivity

class ReposActivity : BaseFragmentActivity() {
    override val fragmentInstance: Fragment
        get() = ReposFragment.newInstance()

    override val layoutResId: Int
        @LayoutRes get() = R.layout.repos_activity
}