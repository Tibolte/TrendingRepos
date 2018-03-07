package fr.northborders.trendingrepos.ui.repodetail

import fr.northborders.mvp.BasePresenterLoader
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class RepoDetailPresenter @Inject constructor(private val getReadme: GetReadme) : BasePresenterLoader<RepoDetailUi>() {
    private val compositeDisposable = CompositeDisposable()

    override fun terminate() {
        super.terminate()
        compositeDisposable.clear()
    }

    fun loadReadMe(owner: String, repoName: String) {
        ui.showLoading()

        val disposable = getReadme.execute(owner, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                ui.hideLoading()
                ui.showReadMe(RepoContentViewModel.Mapper.from(it))
            }, {ui.hideLoading(); ui.showErrorMessage()})

        compositeDisposable.add(disposable)
    }
}