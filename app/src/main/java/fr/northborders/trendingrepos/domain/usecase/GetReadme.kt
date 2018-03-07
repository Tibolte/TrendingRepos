package fr.northborders.trendingrepos.domain.usecase

import fr.northborders.trendingrepos.domain.model.RepoContent
import fr.northborders.trendingrepos.domain.repository.Repository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

open class GetReadme @Inject constructor(@Named("apiGithubDataSource") private val repository: Repository) {
    fun execute(owner: String, repoName: String): Single<RepoContent> {
        return repository.getReadme(owner, repoName)
    }
}