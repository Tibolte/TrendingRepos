package fr.northborders.mvp

abstract class BasePresenterLoader<V : BasePresenterLoader.Ui> : BasePresenter<V>() {

    interface Ui : Presenter.Ui {

        fun hideLoading()

        fun showLoading()
    }
}