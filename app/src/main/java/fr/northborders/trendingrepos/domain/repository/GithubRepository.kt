package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.data.data.ApiGithubDataSource
import fr.northborders.trendingrepos.domain.model.Repo
import io.reactivex.Single
import javax.inject.Inject

open class GithubRepository @Inject constructor(private val apiGithubDataSource: ApiGithubDataSource): Repository {

    override fun getRepos(query: String): Single<List<Repo>> {
        return apiGithubDataSource.getRepos(query).map {
            val repos = ArrayList<Repo>()
            it.mapTo(repos) {
                Repo.Mapper.from(it)
            }
            repos
        }
    }

}