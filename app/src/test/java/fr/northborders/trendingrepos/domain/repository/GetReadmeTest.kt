package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.factory.RepoContentFactory
import fr.northborders.trendingrepos.domain.model.RepoContent
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class GetReadmeTest {
    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock lateinit var repository: GithubRepository
    private lateinit var getReadme: GetReadme

    @Before
    fun setUp() {
        getReadme = GetReadme(repository)
    }

    @Test
    fun shouldReturnARepoContent() {
        val repoContent = givenARepoContentWithData()
        getReadme.execute("","")
            .test()
            .assertNoErrors()
            .assertValue {
                it.name == repoContent.name
            }
    }

    private fun givenARepoContentWithData(): RepoContent {
        val repoContent = RepoContentFactory.makeRepoContent()
        given(getReadme.execute("", "")).willReturn(Single.just(repoContent))
        return repoContent
    }
}