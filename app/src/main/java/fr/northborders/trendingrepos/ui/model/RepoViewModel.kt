package fr.northborders.trendingrepos.ui.model

import fr.northborders.trendingrepos.domain.model.Repo

data class RepoViewModel(
    val id: Long,
    val name: String,
    val fullName: String,
    val _private: Boolean,
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val downloadUrl: String,
    val issuesUrl: String?,
    val releasesUrl: String,
    val createdAt: String,
    val updatedAt: String,
    val pushedAt: String,
    val gitUrl: String,
    val sshUrl: String,
    val cloneUrl: String,
    val homePage: String,
    val size: Int,
    val starGazersCount: Int,
    val watchersCount: Int,
    val language: String,
    val forksCount: Int,
    val mirrorUrl: String?,
    val openIssuesCount: Int,
    val forks: Int,
    val openIssues: Int,
    val watchers: Int,
    val defaultBranch: String,
    val score: Int,
    val owner: UserViewModel
) {
    object Mapper {
        fun from(repo: Repo) =
            RepoViewModel(
                repo.id,
                repo.name,
                repo.fullName,
                repo._private,
                repo.htmlUrl,
                repo.description,
                repo.fork,
                repo.downloadUrl,
                repo.issuesUrl,
                repo.releasesUrl,
                repo.createdAt,
                repo.updatedAt,
                repo.pushedAt,
                repo.gitUrl,
                repo.sshUrl,
                repo.cloneUrl,
                repo.homePage,
                repo.size,
                repo.starGazersCount,
                repo.watchersCount,
                repo.language,
                repo.forksCount,
                repo.mirrorUrl,
                repo.openIssuesCount,
                repo.forks,
                repo.openIssues,
                repo.watchers,
                repo.defaultBranch,
                repo.score,
                UserViewModel.Mapper.from(repo.owner)
            )
    }
}
