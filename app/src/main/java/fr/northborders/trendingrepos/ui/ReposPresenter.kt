package fr.northborders.trendingrepos.ui

import fr.northborders.trendingrepos.domain.usecase.GetRepos
import fr.northborders.trendingrepos.ui.base.BasePresenterLoader
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class ReposPresenter @Inject constructor(private val getRepos: GetRepos) : BasePresenterLoader<ReposUi>() {

    private val compositeDisposable = CompositeDisposable()

    override fun start() {
        super.start()

        ui.showLoading()

        val disposable = getRepos.execute("language:java", "stars", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                ui.hideLoading()
                when (it.isEmpty()) {
                    true -> ui.showEmptyMessage()
                    else -> {
                        val repos = ArrayList<RepoViewModel>()
                        it.mapTo(repos) {
                            RepoViewModel.Mapper.from(it)
                        }
                        ui.showRepos(repos)
                    }
                }
            }, { ui.hideLoading(); ui.showErrorMessage() })

        compositeDisposable.add(disposable)
    }

    override fun terminate() {
        super.terminate()
        compositeDisposable.clear()
    }
}
