package fr.northborders.trendingrepos.domain.model

import fr.northborders.trendingrepos.data.model.RepoContentEntity

data class RepoContent(
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
        fun from(repoContentEntity: RepoContentEntity) =
            RepoContent(
                repoContentEntity.name,
                repoContentEntity.path,
                repoContentEntity.sha,
                repoContentEntity.size,
                repoContentEntity.url,
                repoContentEntity.htmlUrl,
                repoContentEntity.gitUrl,
                repoContentEntity.downloadUrl,
                repoContentEntity.type,
                repoContentEntity.encoding
            )
    }
}