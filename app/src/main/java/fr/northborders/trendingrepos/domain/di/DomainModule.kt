package fr.northborders.trendingrepos.domain.di

import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.data.remote.ApiGithubDataSource
import fr.northborders.trendingrepos.domain.repository.GithubRepository
import fr.northborders.trendingrepos.domain.repository.Repository
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import fr.northborders.trendingrepos.domain.usecase.GetRepos
import fr.northborders.trendingrepos.domain.usecase.Markdown
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides @Singleton @Named("apiGithubDataSource")
    fun providesGithubRepository(apiGithubDataSource: ApiGithubDataSource): Repository =
        GithubRepository(apiGithubDataSource)

    @Provides @Singleton
    fun providesGetRepos(githubRepository: GithubRepository): GetRepos =
        GetRepos(githubRepository)

    @Provides @Singleton
    fun providesGetReadme(githubRepository: GithubRepository): GetReadme =
        GetReadme(githubRepository)

    @Provides @Singleton
    fun providesMarkdown(githubRepository: GithubRepository): Markdown =
        Markdown(githubRepository)
}