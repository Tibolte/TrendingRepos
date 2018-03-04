package fr.northborders.trendingrepos.domain.di

import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.data.data.ApiGithubDataSource
import fr.northborders.trendingrepos.domain.repository.GithubRepository
import fr.northborders.trendingrepos.domain.repository.Repository
import fr.northborders.trendingrepos.domain.usecase.GetRepos
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
}