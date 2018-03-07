package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.factory.RepoContentFactory
import fr.northborders.trendingrepos.domain.usecase.Markdown
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class MarkDownTest {
    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Mock lateinit var repository: GithubRepository
    private lateinit var markdown: Markdown

    @Before
    fun setUp() {
        markdown = Markdown(repository)
    }

    @Test
    fun shouldReturnRawMarkdown() {
        val repoContent = givenARepoContent()
        markdown.execute(repoContent)
            .test()
            .assertNoErrors()
            .assertValue { it == "" }
    }

    private fun givenARepoContent(): String {
        val repoContentForReadme = RepoContentFactory.makeContentForReadme()
        given(markdown.execute(repoContentForReadme)).willReturn(Single.just(""))
        return repoContentForReadme
    }
}