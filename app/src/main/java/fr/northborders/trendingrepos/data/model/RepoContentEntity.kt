package fr.northborders.trendingrepos.data.model

import com.google.gson.annotations.SerializedName

data class RepoContentEntity (
    @SerializedName(NAME) val name: String,
    @SerializedName(PATH) val path: String,
    @SerializedName(SHA) val sha: String,
    @SerializedName(SIZE) val size: Int,
    @SerializedName(URL) val url: String,
    @SerializedName(HTML_URL) val htmlUrl: String,
    @SerializedName(GIT_URL) val gitUrl: String,
    @SerializedName(DOWNLOAD_URL) val downloadUrl: String,
    @SerializedName(TYPE) val type: String,
    @SerializedName(CONTENT) val content: String,
    @SerializedName(ENCODING) val encoding: String
) {
    companion object {
        private const val NAME = "name"
        private const val PATH = "path"
        private const val SHA = "sha"
        private const val SIZE = "size"
        private const val URL = "url"
        private const val HTML_URL = "html_url"
        private const val GIT_URL = "git_url"
        private const val DOWNLOAD_URL = "download_url"
        private const val TYPE = "type"
        private const val CONTENT = "content"
        private const val ENCODING = "encoding"
    }
}