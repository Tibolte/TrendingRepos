package fr.northborders.trendingrepos.domain.mapper

import fr.northborders.trendingrepos.data.model.UserEntity
import fr.northborders.trendingrepos.domain.factory.UserFactory
import fr.northborders.trendingrepos.domain.model.User
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class UserMapperTest {

    @Test
    fun mapFromEntity() {
        val userEntity = UserFactory.makeUserEntity()
        val user = User.Mapper.from(userEntity)
        assertUserEquality(userEntity, user)
    }

    private fun assertUserEquality(userEntity: UserEntity, user: User) {
        assertEquals(userEntity.login, user.login)
        assertEquals(userEntity.id, user.id)
        assertEquals(userEntity.avatarUrl, user.avatarUrl)
        assertEquals(userEntity.gravatarId, user.gravatarId)
        assertEquals(userEntity.url, user.url)
        assertEquals(userEntity.htmlUrl, user.htmlUrl)
        assertEquals(userEntity.followersUrl, user.followersUrl)
        assertEquals(userEntity.followeringUrl, user.followeringUrl)
        assertEquals(userEntity.gistsUrl, user.gistsUrl)
        assertEquals(userEntity.stattedUrl, user.stattedUrl)
        assertEquals(userEntity.stattedUrl, user.stattedUrl)
        assertEquals(userEntity.subscriptionsUrl, user.subscriptionsUrl)
        assertEquals(userEntity.organizationsUrl, user.organizationsUrl)
        assertEquals(userEntity.reposUrl, user.reposUrl)
        assertEquals(userEntity.eventsUrl, user.eventsUrl)
        assertEquals(userEntity.receivedEventsUrl, user.receivedEventsUrl)
        assertEquals(userEntity.type, user.type)
        assertEquals(userEntity.siteAdmin, user.siteAdmin)
        assertEquals(userEntity.score, user.score)
        assertEquals(userEntity.email, user.email)
        assertEquals(userEntity.starGazersCount, user.starGazersCount)
        assertEquals(userEntity.company, user.company)
        assertEquals(userEntity.blog, user.blog)
        assertEquals(userEntity.location, user.location)
        assertEquals(userEntity.createdAt, user.createdAt)
        assertEquals(userEntity.updatedAt, user.updatedAt)
        assertEquals(userEntity.forks, user.forks)
        assertEquals(userEntity.openIssues, user.openIssues)
    }
}
