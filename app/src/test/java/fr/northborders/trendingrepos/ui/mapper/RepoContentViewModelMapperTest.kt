package fr.northborders.trendingrepos.ui.mapper

import fr.northborders.trendingrepos.domain.model.RepoContent
import fr.northborders.trendingrepos.ui.factory.RepoContentViewModelFactory
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class RepoContentViewModelMapperTest {

    @Test
    fun mapFromDomainModel() {
        val repoContent = RepoContentViewModelFactory.makeRepoContent()
        val repoContentViewModel = RepoContentViewModel.Mapper.from(repoContent)
        assertRepoContentEquality(repoContentViewModel, repoContent)
    }

    private fun assertRepoContentEquality(repoContentViewModel: RepoContentViewModel, repoContent: RepoContent) {
        assertEquals(repoContentViewModel.name, repoContent.name)
        assertEquals(repoContentViewModel.path, repoContent.path)
        assertEquals(repoContentViewModel.sha, repoContent.sha)
        assertEquals(repoContentViewModel.size, repoContent.size)
        assertEquals(repoContentViewModel.url, repoContent.url)
        assertEquals(repoContentViewModel.htmlUrl, repoContent.htmlUrl)
        assertEquals(repoContentViewModel.gitUrl, repoContent.gitUrl)
        assertEquals(repoContentViewModel.downloadUrl, repoContent.downloadUrl)
        assertEquals(repoContentViewModel.type, repoContent.type)
        assertEquals(repoContentViewModel.encoding, repoContent.encoding)
    }
}