package fr.northborders.basecomponents

import java.lang.ref.WeakReference

abstract class BasePresenter<V : Presenter.Ui> : Presenter<V> {
    private var view: WeakReference<V>? = null

    override var ui: V
        get() = view!!.get()!!
        set(view) {
            this.view = WeakReference<V>(view)
        }

    override val isViewAttached: Boolean
        get() = view != null && view!!.get() != null

    override fun start() {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun stop() {
        this.view!!.clear()
    }

    override fun terminate() {
        view = null
    }
}