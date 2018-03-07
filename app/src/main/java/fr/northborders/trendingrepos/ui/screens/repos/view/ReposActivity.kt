package fr.northborders.trendingrepos.ui.screens.repos.view

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import fr.northborders.trendingrepos.R
import fr.northborders.mvp.BaseFragmentActivity

class ReposActivity : BaseFragmentActivity() {
    override val fragmentInstance: Fragment
        get() = ReposFragment.newInstance()

    override val layoutResId: Int
        @LayoutRes get() = R.layout.activity_base
}
