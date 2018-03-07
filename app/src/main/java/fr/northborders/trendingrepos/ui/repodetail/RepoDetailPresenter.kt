package fr.northborders.trendingrepos.ui.repodetail

import fr.northborders.mvp.BasePresenterLoader
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import fr.northborders.trendingrepos.domain.usecase.Markdown
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class RepoDetailPresenter @Inject constructor(private val getReadme: GetReadme, private val markdown: Markdown) : BasePresenterLoader<RepoDetailUi>() {
    private val compositeDisposable = CompositeDisposable()

    override fun terminate() {
        super.terminate()
        compositeDisposable.clear()
    }

    fun loadReadMe(owner: String?, repoName: String?) {
        ui.showLoading()

        val disposable = getReadme.execute(owner, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                ui.readmeLoaded(RepoContentViewModel.Mapper.from(it))
            }, {ui.hideLoading(); ui.showErrorMessage()})

        compositeDisposable.add(disposable)
    }

    fun markdown(readme: String) {
        val disposable = markdown.execute(readme)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                ui.hideLoading()
                ui.showMarkdown(it)
            }, {ui.hideLoading(); ui.showErrorMessage()})

        compositeDisposable.add(disposable)
    }
}