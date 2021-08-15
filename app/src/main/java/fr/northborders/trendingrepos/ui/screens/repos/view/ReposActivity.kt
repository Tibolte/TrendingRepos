package fr.northborders.trendingrepos.ui.screens.repos.view

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import fr.northborders.basecomponents.BaseFragmentActivity
import fr.northborders.trendingrepos.R

class ReposActivity : BaseFragmentActivity() {
    override val fragmentInstance: Fragment
        get() = ReposFragment.newInstance()

    override val layoutResId: Int
        @LayoutRes get() = R.layout.activity_base
}