package fr.northborders.trendingrepos.data.model

import com.google.gson.annotations.SerializedName

data class RepoEntity(
    @SerializedName(ID) val id: Long,
    @SerializedName(NAME) val name: String,
    @SerializedName(FULL_NAME) val fullName: String,
    @SerializedName(PRIVATE) val _private: Boolean,
    @SerializedName(HTML_URL) val htmlUrl: String,
    @SerializedName(DESCRIPTION) val description: String,
    @SerializedName(FORK) val fork: Boolean,
    @SerializedName(DOWNLOAD_URL) val downloadUrl: String,
    @SerializedName(ISSUES_URL) val issuesUrl: String?,
    @SerializedName(RELEASES_URL) val releasesUrl: String,
    @SerializedName(CREATED_AT) val createdAt: String,
    @SerializedName(UPDATED_AT) val updatedAt: String,
    @SerializedName(PUSHED_AT) val pushedAt: String,
    @SerializedName(GIT_URL) val gitUrl: String,
    @SerializedName(SSH_URL) val sshUrl: String,
    @SerializedName(CLONE_URL) val cloneUrl: String,
    @SerializedName(HOMEPAGE) val homePage: String,
    @SerializedName(SIZE) val size: Int,
    @SerializedName(STARGAZERS_COUNT) val starGazersCount: Int,
    @SerializedName(WATCHERS_COUNT) val watchersCount: Int,
    @SerializedName(LANGUAGE) val language: String,
    @SerializedName(FORKS_COUNT) val forksCount: Int,
    @SerializedName(MIRROR_URL) val mirrorUrl: String?,
    @SerializedName(OPEN_ISSUES_COUNT) val openIssuesCount: Int,
    @SerializedName(FORKS) val forks: Int,
    @SerializedName(OPEN_ISSUES) val openIssues: Int,
    @SerializedName(WATCHERS) val watchers: Int,
    @SerializedName(DEFAULT_BRANCH) val defaultBranch: String,
    @SerializedName(SCORE) val score: Int,
    @SerializedName(OWNER) val owner: UserEntity
) {
    companion object {
        private const val ID = "id"
        private const val NAME = "name"
        private const val FULL_NAME = "full_name"
        private const val PRIVATE = "private"
        private const val HTML_URL = "html_url"
        private const val DESCRIPTION = "description"
        private const val FORK = "fork"
        private const val DOWNLOAD_URL = "downloads_url"
        private const val ISSUES_URL = "issues_url"
        private const val PULLS_URL = "pulls_url"
        private const val RELEASES_URL = "releases_url"
        private const val CREATED_AT = "created_at"
        private const val UPDATED_AT = "updated_at"
        private const val PUSHED_AT = "pushed_at"
        private const val GIT_URL = "git_url"
        private const val SSH_URL = "ssh_url"
        private const val CLONE_URL = "clone_url"
        private const val HOMEPAGE = "homepage"
        private const val SIZE = "size"
        private const val STARGAZERS_COUNT = "stargazers_count"
        private const val WATCHERS_COUNT = "watchers_count"
        private const val LANGUAGE = "language"
        private const val FORKS_COUNT = "forks_count"
        private const val MIRROR_URL = "mirror_url"
        private const val OPEN_ISSUES_COUNT = "open_issues_count"
        private const val FORKS = "forks"
        private const val OPEN_ISSUES = "open_issues"
        private const val WATCHERS = "watchers"
        private const val DEFAULT_BRANCH = "default_branch"
        private const val SCORE = "score"
        private const val OWNER = "owner"
    }
}
