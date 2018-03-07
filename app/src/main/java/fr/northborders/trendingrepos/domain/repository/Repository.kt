package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.domain.model.RepoContent
import io.reactivex.Single

interface Repository {
    fun getRepos(query: String, sort: String, page: Int): Single<List<Repo>>
    fun getReadme(owner: String?, repoName: String?): Single<RepoContent>
    fun markdown(readme: String): Single<String>
}
