package fr.northborders.trendingrepos.ui.presenter

import fr.northborders.trendingrepos.domain.model.RepoContent
import fr.northborders.trendingrepos.domain.repository.GithubRepository
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import fr.northborders.trendingrepos.domain.usecase.Markdown
import fr.northborders.trendingrepos.ui.RxAndroidRule
import fr.northborders.trendingrepos.ui.factory.RepoContentViewModelFactory
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel
import fr.northborders.trendingrepos.ui.screens.repodetail.RepoDetailPresenter
import fr.northborders.trendingrepos.ui.screens.repodetail.RepoDetailUi
import io.reactivex.Single
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class RepoDetailPresenterTest {
    companion object {
        @ClassRule
        @JvmField
        val blockingRxAndroidTestRule = RxAndroidRule()
    }

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock lateinit var ui: RepoDetailUi
    @Mock lateinit var repository: GithubRepository
    @Mock lateinit var getReadme: GetReadme
    @Mock
    lateinit var markdown : Markdown

    private lateinit var presenter: RepoDetailPresenter

    @Before
    fun setUp() {
        getReadme = GetReadme(repository)
        presenter = RepoDetailPresenter(getReadme, markdown)
        presenter.ui = ui
    }

    @Test
    fun shouldShowTheRepoContent() {
        val repoContent = givenARepoContentWithData()
        val repoContentViewModel = RepoContentViewModel.Mapper.from(repoContent)

        presenter.start()
        presenter.loadReadMe("", "")

        Mockito.verify(ui).showLoading()
        //Mockito.verify(ui).hideLoading()
        Mockito.verify(ui).readmeLoaded(repoContentViewModel)
    }

    @Test
    fun shouldShowErrorMessageIfGetRepoContentSingleError() {
        givenAnErrorRepoContent()

        presenter.start()
        presenter.loadReadMe("", "")

        Mockito.verify(ui).showLoading()
        Mockito.verify(ui).hideLoading()
        Mockito.verify(ui).showErrorMessage()
    }

    private fun givenARepoContentWithData(): RepoContent {
        val repoContent = RepoContentViewModelFactory.makeRepoContent()
        given(getReadme.execute("","")).willReturn(Single.just(repoContent))
        return repoContent
    }

    private fun givenAnErrorRepoContent() =
        given(getReadme.execute("", "")).willReturn(Single.error(Throwable("An error occurred")))
}