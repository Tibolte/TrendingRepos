package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.model.Repo
import io.reactivex.Single

interface Repository {
    fun getRepos(query: String): Single<List<Repo>>
}
