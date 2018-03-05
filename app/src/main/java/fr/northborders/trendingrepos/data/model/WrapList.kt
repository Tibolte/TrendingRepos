package fr.northborders.trendingrepos.data.model

import com.google.gson.annotations.SerializedName

data class WrapList(
    @SerializedName(TOTAL_COUNT) val totalCount: Int,
    @SerializedName(INCOMPLETE_RESULTS) val incompleteResults: Boolean,
    @SerializedName(ITEMS) val items: List<RepoEntity>
) {
    companion object {
        private const val TOTAL_COUNT = "total_count"
        private const val INCOMPLETE_RESULTS = "incomplete_results"
        private const val ITEMS = "items"
    }
}