package fr.northborders.trendingrepos.domain.usecase

import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.domain.repository.Repository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

open class GetRepos @Inject constructor(@Named("apiGithubDataSource") private val repository: Repository) {
    fun execute(query: String, sort: String, page: Int): Single<List<Repo>> {
        return repository.getRepos(query, sort, page)
    }
}