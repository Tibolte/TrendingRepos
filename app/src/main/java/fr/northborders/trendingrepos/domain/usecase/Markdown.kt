package fr.northborders.trendingrepos.domain.usecase

import fr.northborders.trendingrepos.domain.repository.Repository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

open class Markdown @Inject constructor(@Named("apiGithubDataSource") private val repository: Repository) {
    fun execute(readme: String): Single<String> {
        return repository.markdown(readme)
    }
}