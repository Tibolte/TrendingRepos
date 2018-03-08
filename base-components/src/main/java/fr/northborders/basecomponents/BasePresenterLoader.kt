package fr.northborders.basecomponents

abstract class BasePresenterLoader<V : BasePresenterLoader.Ui> : BasePresenter<V>() {

    interface Ui : Presenter.Ui {

        fun hideLoading()

        fun showLoading()
    }
}