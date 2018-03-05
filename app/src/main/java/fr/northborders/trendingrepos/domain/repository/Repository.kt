package fr.northborders.trendingrepos.domain.repository

import fr.northborders.trendingrepos.domain.model.Repo
import io.reactivex.Single

interface Repository {
    fun getRepos(query: String, sort: String, page: Int): Single<List<Repo>>
}
