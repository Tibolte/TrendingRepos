package fr.northborders.trendingrepos.data.data

import javax.inject.Inject

open class ApiGithubDataSource @Inject constructor(private val githubService: GithubService) {
    fun getRepos(query: String, sort: String, page: Int) = githubService.getRepos(query, sort, page)
}
