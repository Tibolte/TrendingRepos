package fr.northborders.trendingrepos.ui.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(), Presenter.Ui {

    /**
     * @return the layout id associated to the layout used in the fragment.
     */

    @get:LayoutRes protected abstract val layoutResId: Int

    /**
     * @return a Toolbar of activity
     */

    protected val baseToolbar: Toolbar?
        get() = (activity as BaseActivity).baseToolbar

    /**
     * @return the [BaseActivity] if you need the activity context.
     */

    protected val baseActivity: BaseActivity
        get() = activity as BaseActivity

    /**
     * @return the [ActionBar] for you can configure it.
     */

    protected val supportActionBar: ActionBar
        get() = (activity as BaseActivity).supportActionBar!!

    /**
     * @return the FragmentManager for interacting with fragments associated
     * with this activity.
     */

    protected val activitySupportFragmentManager: FragmentManager
        get() = activity!!.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(hasMenu())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
        initFragment(view)
    }

    /**
     * Called immediately after onCreateView(LayoutInflater, ViewGroup, Bundle) has returned
     * Override this method to configure your fragment or start views.
     *
     * @param view The Ui returned by [.onCreateView].
     */

    open fun initFragment(view: View) {

    }

    /**
     * Called before to start all the presenter instances linked to the component lifecycle.
     * Override this method to configure your presenter with extra data if needed.
     */
    open fun initPresenter() {

    }

    /**
     * @return hasMenu If true, the fragment has menu items to contribute.
     */

    protected fun hasMenu(): Boolean {
        return true
    }

    /**
     * @return set ActionBar in a Fragment
     */

    protected fun setSupportActionBarOnFragment(toolbar: Toolbar) {
        (activity as BaseActivity).setSupportActionBar(toolbar)
    }

    /**
     * Use this method if you need call onDestroy method of Activity
     */

    protected fun finishActivity() {
        activity!!.finish()
    }

    /**
     * Use this method if you need replace an existing fragment that was added to a container
     *
     * @param containerViewId Identifier of the container whose fragment(s) are to be replaced
     * @param fragment The new fragment to place in the container
     */

    protected fun onReplaceTransaction(@IdRes containerViewId: Int, fragment: Fragment) {
        activitySupportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }

    /**
     * Use this method if you need replace an existing fragment that was added to a container
     * and you need add to BackStack
     *
     * @param containerViewId Identifier of the container whose fragment(s) are to be replaced
     * @param fragment The new fragment to place in the container
     */

    protected fun onReplaceTransactionWithBackStack(@IdRes containerViewId: Int,
                                                    fragment: Fragment) {
        activitySupportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .addToBackStack(Fragment::class.java.canonicalName)
            .commit()
    }
}
