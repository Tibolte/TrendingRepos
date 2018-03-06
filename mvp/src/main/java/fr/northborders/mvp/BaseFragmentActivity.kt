package fr.northborders.mvp

import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment

abstract class BaseFragmentActivity : BaseActivity() {

    /**
     * @return nested target fragment
     */
    var nestedTargetFragment: Fragment? = null
        private set

    /**
     * @return the layout id associated to the layout used in the fragment.
     */

    protected override val layoutResId: Int
        @LayoutRes get() = R.layout.default_container

    /**
     * @return containerViewId Optional identifier of the container this fragment is
     * to be placed in.
     */

    protected val containerId: Int?
        @IdRes get() = R.id.container

    /**
     * @return The new fragment to place in the container
     */

    protected abstract val fragmentInstance: Fragment

    protected override fun initActivity() {
        super.initActivity()
        initFragment()
    }

    /**
     * Initialize a fragment into an Activity
     */

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        var containerId = R.id.container
        if (containerId != null) {
            containerId = containerId
        }
        nestedTargetFragment = fragmentManager.findFragmentById(containerId!!)
        if (nestedTargetFragment == null) {
            nestedTargetFragment = fragmentInstance
            fragmentManager.beginTransaction().add(containerId!!, nestedTargetFragment).commit()
        }
    }
}