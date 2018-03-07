package fr.northborders.trendingrepos.data.data

import javax.inject.Inject

open class ApiGithubDataSource @Inject constructor(private val githubService: GithubService, private val markdownService: MarkdownService) {
    fun getRepos(query: String, sort: String, page: Int) = githubService.getRepos(query, sort, page)
    fun getReadme(owner: String?, repoName: String?) = githubService.getReadme(owner, repoName)
    fun markdown(readme: String) = markdownService.markdown(readme)
}
