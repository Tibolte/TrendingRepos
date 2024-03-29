package fr.northborders.trendingrepos.ui.model

import fr.northborders.trendingrepos.domain.model.User
import java.io.Serializable

data class UserViewModel(
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followeringUrl: String? = "",
    val gistsUrl: String,
    val stattedUrl: String? = "",
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val siteAdmin: Boolean
) : Serializable {
    object Mapper {
        fun from(user: User) =
            UserViewModel(
                user.login,
                user.id,
                user.avatarUrl,
                user.gravatarId,
                user.url,
                user.htmlUrl,
                user.followersUrl,
                user.followeringUrl,
                user.gistsUrl,
                user.stattedUrl,
                user.subscriptionsUrl,
                user.organizationsUrl,
                user.reposUrl,
                user.eventsUrl,
                user.receivedEventsUrl,
                user.type,
                user.siteAdmin
            )
    }
}