package fr.northborders.trendingrepos.ui.mapper

import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.ui.factory.RepoViewModelFactory
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class RepoViewModelMapperTest {

    @Test
    fun mapFromDomainModel() {
        val repo = RepoViewModelFactory.makeRepo()
        val repoViewModel = RepoViewModel.Mapper.from(repo)
        assertRepoEquality(repoViewModel, repo)
    }

    private fun assertRepoEquality(repoViewModel: RepoViewModel, repo: Repo) {
        assertEquals(repoViewModel.id, repo.id)
        assertEquals(repoViewModel.name, repo.name)
        assertEquals(repoViewModel.fullName, repo.fullName)
        assertEquals(repoViewModel._private, repo._private)
        assertEquals(repoViewModel.htmlUrl, repo.htmlUrl)
        assertEquals(repoViewModel.description, repo.description)
        assertEquals(repoViewModel.fullName, repo.fullName)
        assertEquals(repoViewModel.fork, repo.fork)
        assertEquals(repoViewModel.downloadUrl, repo.downloadUrl)
        assertEquals(repoViewModel.issuesUrl, repo.issuesUrl)
        assertEquals(repoViewModel.releasesUrl, repo.releasesUrl)
        assertEquals(repoViewModel.createdAt, repo.createdAt)
        assertEquals(repoViewModel.updatedAt, repo.updatedAt)
        assertEquals(repoViewModel.pushedAt, repo.pushedAt)
        assertEquals(repoViewModel.gitUrl, repo.gitUrl)
        assertEquals(repoViewModel.sshUrl, repo.sshUrl)
        assertEquals(repoViewModel.cloneUrl, repo.cloneUrl)
        assertEquals(repoViewModel.homePage, repo.homePage)
        assertEquals(repoViewModel.size, repo.size)
        assertEquals(repoViewModel.starGazersCount, repo.starGazersCount)
        assertEquals(repoViewModel.watchersCount, repo.watchersCount)
        assertEquals(repoViewModel.language, repo.language)
        assertEquals(repoViewModel.forksCount, repo.forksCount)
        assertEquals(repoViewModel.mirrorUrl, repo.mirrorUrl)
        assertEquals(repoViewModel.openIssuesCount, repo.openIssuesCount)
        assertEquals(repoViewModel.forks, repo.forks)
        assertEquals(repoViewModel.openIssues, repo.openIssues)
        assertEquals(repoViewModel.watchers, repo.watchers)
        assertEquals(repoViewModel.defaultBranch, repo.defaultBranch)
        assertEquals(repoViewModel.score, repo.score)
    }
}