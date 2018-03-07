package fr.northborders.trendingrepos.ui.model

import fr.northborders.trendingrepos.domain.model.RepoContent

data class RepoContentViewModel(
    val name: String,
    val path: String,
    val sha: String,
    val size: Int,
    val url: String,
    val htmlUrl: String,
    val gitUrl: String,
    val downloadUrl: String,
    val type: String,
    val encoding: String
) {
    object Mapper {
        fun from(repoContent: RepoContent): RepoContentViewModel {
            return RepoContentViewModel(
                repoContent.name,
                repoContent.path,
                repoContent.sha,
                repoContent.size,
                repoContent.url,
                repoContent.htmlUrl,
                repoContent.gitUrl,
                repoContent.downloadUrl,
                repoContent.type,
                repoContent.encoding
            )
        }
    }
}