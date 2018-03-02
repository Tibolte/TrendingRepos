package fr.northborders.trendingrepos.data.repository

import fr.northborders.trendingrepos.data.model.RepoEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun getRepos(@Query("q") query: String, @Query("page") pageId: Int): Single<List<RepoEntity>>
}
