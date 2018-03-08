package fr.northborders.basecomponents

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import fr.northborders.basecomponents.StringsUtils.EXTRA_ARGUMENTS

abstract class BaseActivity : AppCompatActivity() {

    /**
     * @return Toolbar if you need configure directly the toolbar
     */

    var baseToolbar: Toolbar? = null
    var activityArguments: Bundle? = null

    /**
     * @return the layout id associated to the layout used in the activity.
     */

    @get:LayoutRes protected abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initSupportActionBar()
        initArguments(savedInstanceState)
        initPresenter()
        initActivity()
    }

    /**
     * Toolbar will be configured like a [ActionBar] if exists in the layout
     * if it doesn't exist will be ignored
     */

    private fun initSupportActionBar() {
        baseToolbar = findViewById<Toolbar>(R.id.toolbar)
        if (baseToolbar != null) {
            setSupportActionBar(baseToolbar)
            onSetupSupportActionBar(supportActionBar)
        }
    }

    /**
     * Called just after bindViews.
     * Override this method to configure your [ActionBar]
     */

    protected fun onSetupSupportActionBar(actionBar: ActionBar?) {

    }

    /**
     * Called after to start ui state.
     * Override this method to configure your presenter with extra data if needed.
     */

    protected fun initArguments(savedInstanceState: Bundle?) {
        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_ARGUMENTS)) {
            activityArguments = savedInstanceState.getBundle(EXTRA_ARGUMENTS)
        } else if (intent.extras != null) {
            activityArguments = intent.extras!!.getBundle(EXTRA_ARGUMENTS)
        }
    }

    /**
     * Called before to start all the presenter instances linked to the component lifecycle.
     * Override this method to configure your presenter with extra data if needed.
     */

    protected fun initPresenter() {

    }

    /**
     * Called just after setContentView.
     * Override this method to configure your activity or start views
     */

    protected open fun initActivity() {

    }
}