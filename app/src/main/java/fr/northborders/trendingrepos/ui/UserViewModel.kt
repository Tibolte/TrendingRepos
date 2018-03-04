package fr.northborders.trendingrepos.ui

import fr.northborders.trendingrepos.domain.model.User

data class UserViewModel(
    val login: String,
    val id: Int,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followeringUrl: String,
    val gistsUrl: String,
    val stattedUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val siteAdmin: Boolean,
    val score: Int,
    val email: String,
    val starGazersCount: String,
    val company: String,
    val blog: String,
    val location: String,
    val createdAt: String,
    val updatedAt: String,
    val forks: Int,
    val openIssues: Int
) {
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
                user.siteAdmin,
                user.score,
                user.email,
                user.starGazersCount,
                user.company,
                user.blog,
                user.location,
                user.createdAt,
                user.updatedAt,
                user.forks,
                user.openIssues
            )
    }
}
