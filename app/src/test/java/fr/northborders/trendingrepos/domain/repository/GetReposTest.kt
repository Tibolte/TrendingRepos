package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.factory.RepoFactory
import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.domain.usecase.GetRepos
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class GetReposTest {
    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock lateinit var repository: GithubRepository
    private lateinit var getRepos: GetRepos

    @Before
    fun setUp() {
        getRepos = GetRepos(repository)
    }

    @Test
    fun shouldReturnARepoList() {
        val repoList = givenARepoListWithData()
        getRepos.execute("")
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == repoList.size && it[0].id == repoList[0].id
            }
    }

    private fun givenARepoListWithData(): List<Repo> {
        val repoList = RepoFactory.makeRepoList(20)
        given(getRepos.execute("")).willReturn(Single.just(repoList))
        return repoList
    }
}
