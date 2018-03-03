package fr.northborders.trendingrepos.ui.base


interface Presenter<V> {

    var ui: V

    val isViewAttached: Boolean

    fun start()

    fun resume()

    fun pause()

    fun stop()

    fun terminate()

    interface Ui
}
