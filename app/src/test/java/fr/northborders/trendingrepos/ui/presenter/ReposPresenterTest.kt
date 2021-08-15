package fr.northborders.trendingrepos.ui.presenter

import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.domain.repository.GithubRepository
import fr.northborders.trendingrepos.domain.usecase.GetRepos
import fr.northborders.trendingrepos.ui.RxAndroidRule
import fr.northborders.trendingrepos.ui.factory.RepoViewModelFactory
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.screens.repos.ReposPresenter
import fr.northborders.trendingrepos.ui.screens.repos.ReposUi
import io.reactivex.Single
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class ReposPresenterTest {

    companion object {
        @ClassRule
        @JvmField
        val blockingRxAndroidTestRule = RxAndroidRule()
    }

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock
    lateinit var ui: ReposUi
    @Mock lateinit var repository: GithubRepository
    @Mock lateinit var getRepos: GetRepos

    private lateinit var presenter: ReposPresenter

    @Before
    fun setUp() {
        getRepos = GetRepos(repository)
        presenter = ReposPresenter(getRepos)
        presenter.ui = ui
    }

    @Test
    fun shouldShowTheRepoList() {
        val reposList = givenARepoListWithData()
        val repoViewModelList = reposList.map { repo -> RepoViewModel.Mapper.from(repo) }

        presenter.start()

        Mockito.verify(ui).showLoading()
        Mockito.verify(ui).hideLoading()
        Mockito.verify(ui).showRepos(repoViewModelList)
    }

    @Test
    fun shouldShowEmptyMessageIfRepoListIsEmpty() {
        givenAnEmptyRepoList()

        presenter.start()

        Mockito.verify(ui).showLoading()
        Mockito.verify(ui).hideLoading()
        Mockito.verify(ui).showEmptyMessage()
    }

    @Test
    fun shouldShowErrorMessageIfGetReposReturnsAnSingleError() {
        givenAnErrorRepoList()

        presenter.start()

        Mockito.verify(ui).showLoading()
        Mockito.verify(ui).hideLoading()
        Mockito.verify(ui).showErrorMessage()

    }

    private fun givenARepoListWithData(): List<Repo> {
        val repoList = RepoViewModelFactory.makeRepoList(20)
        given(getRepos.execute("language:java", "stars", 1)).willReturn(Single.just(repoList))
        return repoList
    }

    private fun givenAnEmptyRepoList() =
        given(getRepos.execute("language:java", "stars", 1)).willReturn(Single.just(emptyList<Repo>()))

    private fun givenAnErrorRepoList() =
        given(getRepos.execute("language:java", "stars", 1)).willReturn(Single.error(Throwable("An error occurred")))
}