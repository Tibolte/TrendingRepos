package fr.northborders.trendingrepos.data.data

import fr.northborders.trendingrepos.data.model.WrapList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun getRepos(@Query("q") query: String, @Query("sort") sort: String, @Query("page") page: Int): Single<WrapList>
}
