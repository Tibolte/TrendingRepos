package fr.northborders.trendingrepos.ui.screens.repos

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerScrollMoreListener constructor(layoutManager: LinearLayoutManager, loadMoreListener: OnLoadMoreListener): RecyclerView.OnScrollListener() {

    val loadMoreListener: OnLoadMoreListener = loadMoreListener
    var currentPage = 1
    var previousTotalItemCount = 0
    var loading = true
    val layoutManager: RecyclerView.LayoutManager = layoutManager

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        if (layoutManager != null) {
            var lastVisibleItemPosition = 0
            val totalItemCount = layoutManager.itemCount

            lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

            if (totalItemCount < previousTotalItemCount) {
                currentPage = 1
                previousTotalItemCount = totalItemCount
                if (totalItemCount == 0) {
                    loading = true
                }
            }

            if (loading && totalItemCount > previousTotalItemCount) {
                loading = false
                previousTotalItemCount = totalItemCount
            }

            val visibleThreshold = 5
            if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
                currentPage++
                Log.d(RecyclerScrollMoreListener::class.simpleName, "shouldLoad More")
                Log.d(RecyclerScrollMoreListener::class.simpleName, String.format("current page: %d", currentPage))
                Log.d(RecyclerScrollMoreListener::class.simpleName, String.format("lastVisibleItemPosition: %d", lastVisibleItemPosition))
                loadMoreListener.onLoadMore(currentPage, totalItemCount)
                loading = true
            }
        }
    }

    interface OnLoadMoreListener {
        fun onLoadMore(page: Int, total: Int)
    }
}