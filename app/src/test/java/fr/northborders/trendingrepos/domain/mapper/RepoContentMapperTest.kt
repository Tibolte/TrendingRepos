package fr.northborders.trendingrepos.domain.mapper

import fr.northborders.trendingrepos.data.model.RepoContentEntity
import fr.northborders.trendingrepos.domain.factory.RepoContentFactory
import fr.northborders.trendingrepos.domain.model.RepoContent
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepoContentMapperTest {

    @Test
    fun mapFromEntity() {
        val repoContentEntity = RepoContentFactory.makeRepoContentEntity()
        val repoContent = RepoContent.Mapper.from(repoContentEntity)
        assertRepoContentEquality(repoContentEntity, repoContent)
    }

    private fun assertRepoContentEquality(repoContentEntity: RepoContentEntity, repoContent: RepoContent) {
        assertEquals(repoContentEntity.name, repoContent.name)
        assertEquals(repoContentEntity.path, repoContent.path)
        assertEquals(repoContentEntity.sha, repoContent.sha)
        assertEquals(repoContentEntity.size, repoContent.size)
        assertEquals(repoContentEntity.url, repoContent.url)
        assertEquals(repoContentEntity.htmlUrl, repoContent.htmlUrl)
        assertEquals(repoContentEntity.gitUrl, repoContent.gitUrl)
        assertEquals(repoContentEntity.downloadUrl, repoContent.downloadUrl)
        assertEquals(repoContentEntity.type, repoContent.type)
        assertEquals(repoContentEntity.content, repoContent.content)
        assertEquals(repoContentEntity.encoding, repoContent.encoding)
    }
}