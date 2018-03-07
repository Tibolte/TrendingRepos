package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.data.data.ApiGithubDataSource
import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.domain.model.RepoContent
import io.reactivex.Single
import javax.inject.Inject

open class GithubRepository @Inject constructor(private val apiGithubDataSource: ApiGithubDataSource): Repository {

    override fun getRepos(query: String, sort: String, page: Int): Single<List<Repo>> {
        return apiGithubDataSource.getRepos(query, sort, page).map {
            val repos = ArrayList<Repo>()
            val items = it.items
            items.mapTo(repos) {
                Repo.Mapper.from(it)
            }
            repos
        }
    }

    override fun getReadme(owner: String, repoName: String): Single<RepoContent> {
        return apiGithubDataSource.getReadme(owner, repoName).map {
            RepoContent.Mapper.from(it)
        }
    }
}