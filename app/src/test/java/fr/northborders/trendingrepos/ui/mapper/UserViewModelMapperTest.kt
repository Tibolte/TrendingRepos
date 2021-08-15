package fr.northborders.trendingrepos.ui.mapper

import fr.northborders.trendingrepos.domain.model.User
import fr.northborders.trendingrepos.ui.factory.UserViewModelFactory
import fr.northborders.trendingrepos.ui.model.UserViewModel
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class UserViewModelMapperTest {

    @Test
    fun mapFromDomainModel() {
        val user = UserViewModelFactory.makeUser()
        val userViewModel = UserViewModel.Mapper.from(user)
        assertUserEquality(userViewModel, user)
    }

    private fun assertUserEquality(userViewModel: UserViewModel, user: User) {
        assertEquals(userViewModel.login, user.login)
        assertEquals(userViewModel.id, user.id)
        assertEquals(userViewModel.avatarUrl, user.avatarUrl)
        assertEquals(userViewModel.gravatarId, user.gravatarId)
        assertEquals(userViewModel.url, user.url)
        assertEquals(userViewModel.htmlUrl, user.htmlUrl)
        assertEquals(userViewModel.followersUrl, user.followersUrl)
        assertEquals(userViewModel.followeringUrl, user.followeringUrl)
        assertEquals(userViewModel.gistsUrl, user.gistsUrl)
        assertEquals(userViewModel.stattedUrl, user.stattedUrl)
        assertEquals(userViewModel.stattedUrl, user.stattedUrl)
        assertEquals(userViewModel.subscriptionsUrl, user.subscriptionsUrl)
        assertEquals(userViewModel.organizationsUrl, user.organizationsUrl)
        assertEquals(userViewModel.reposUrl, user.reposUrl)
        assertEquals(userViewModel.eventsUrl, user.eventsUrl)
        assertEquals(userViewModel.receivedEventsUrl, user.receivedEventsUrl)
        assertEquals(userViewModel.type, user.type)
        assertEquals(userViewModel.siteAdmin, user.siteAdmin)
    }
}