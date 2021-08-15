package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.data.model.RepoContentEntity
import fr.northborders.trendingrepos.data.model.WrapList
import fr.northborders.trendingrepos.data.remote.ApiGithubDataSource
import fr.northborders.trendingrepos.data.remote.GithubService
import fr.northborders.trendingrepos.data.remote.MarkdownService
import fr.northborders.trendingrepos.domain.factory.RepoContentFactory
import fr.northborders.trendingrepos.domain.factory.RepoFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class GithubRepositoryTest {

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock lateinit var githubService: GithubService
    @Mock lateinit var markdownService: MarkdownService
    @Mock
    lateinit var dataSource: ApiGithubDataSource

    private lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        dataSource = ApiGithubDataSource(githubService, markdownService)
        repository = GithubRepository(dataSource)
    }

    @Test
    fun shouldReturnRepoEntityList() {
        val repoList = givenARepoEntityListWithData()

        repository.getRepos("", "", 1)
            .test()
            .assertNoErrors()
            .assertValue {
                it.size == repoList.items.size && it[0].id == repoList.items[0].id
            }
    }

    @Test
    fun shouldReturnRepoContentEntity() {
        val repoContentEntity = givenARepoContentEntityWithData()

        repository.getReadme("", "")
            .test()
            .assertNoErrors()
            .assertValue {
                it.name == repoContentEntity.name
            }
    }

    private fun givenARepoEntityListWithData(): WrapList {
        val repoList = WrapList(20, false, RepoFactory.makeRepoEntityList(20))
        given(dataSource.getRepos("", "", 1)).willReturn(Single.just(repoList))
        return repoList
    }

    private fun givenARepoContentEntityWithData(): RepoContentEntity {
        val repoContentEntity = RepoContentFactory.makeRepoContentEntity()
        given(dataSource.getReadme("", "")).willReturn(Single.just(repoContentEntity))
        return repoContentEntity
    }
}