package fr.northborders.trendingrepos.domain.mapper

import fr.northborders.trendingrepos.data.model.RepoEntity
import fr.northborders.trendingrepos.domain.factory.RepoFactory
import fr.northborders.trendingrepos.domain.model.Repo
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepoMapperTest {

    @Test
    fun mapFromEntity() {
        val repoEntity = RepoFactory.makeRepoEntity()
        val repo = Repo.Mapper.from(repoEntity)
        assertRepoEquality(repoEntity, repo)
    }

    private fun assertRepoEquality(repoEntity: RepoEntity, repo: Repo) {
        assertEquals(repoEntity.id, repo.id)
        assertEquals(repoEntity.name, repo.name)
        assertEquals(repoEntity.fullName, repo.fullName)
        assertEquals(repoEntity._private, repo._private)
        assertEquals(repoEntity.htmlUrl, repo.htmlUrl)
        assertEquals(repoEntity.description, repo.description)
        assertEquals(repoEntity.fullName, repo.fullName)
        assertEquals(repoEntity.fork, repo.fork)
        assertEquals(repoEntity.downloadUrl, repo.downloadUrl)
        assertEquals(repoEntity.issuesUrl, repo.issuesUrl)
        assertEquals(repoEntity.releasesUrl, repo.releasesUrl)
        assertEquals(repoEntity.createdAt, repo.createdAt)
        assertEquals(repoEntity.updatedAt, repo.updatedAt)
        assertEquals(repoEntity.pushedAt, repo.pushedAt)
        assertEquals(repoEntity.gitUrl, repo.gitUrl)
        assertEquals(repoEntity.sshUrl, repo.sshUrl)
        assertEquals(repoEntity.cloneUrl, repo.cloneUrl)
        assertEquals(repoEntity.homePage, repo.homePage)
        assertEquals(repoEntity.size, repo.size)
        assertEquals(repoEntity.starGazersCount, repo.starGazersCount)
        assertEquals(repoEntity.watchersCount, repo.watchersCount)
        assertEquals(repoEntity.language, repo.language)
        assertEquals(repoEntity.forksCount, repo.forksCount)
        assertEquals(repoEntity.mirrorUrl, repo.mirrorUrl)
        assertEquals(repoEntity.openIssuesCount, repo.openIssuesCount)
        assertEquals(repoEntity.forks, repo.forks)
        assertEquals(repoEntity.openIssues, repo.openIssues)
        assertEquals(repoEntity.watchers, repo.watchers)
        assertEquals(repoEntity.defaultBranch, repo.defaultBranch)
        assertEquals(repoEntity.score, repo.score)
    }
}