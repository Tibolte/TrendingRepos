package fr.northborders.trendingrepos.data.data

import fr.northborders.trendingrepos.data.model.RepoContentEntity
import fr.northborders.trendingrepos.data.model.WrapList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    fun getRepos(@Query("q") query: String, @Query("sort") sort: String, @Query("page") page: Int): Single<WrapList>

    @GET("repos/{owner}/{repo}/readme")
    fun getReadme(@Path("owner") owner: String, @Path("repo") repoName: String): Single<RepoContentEntity>
}
