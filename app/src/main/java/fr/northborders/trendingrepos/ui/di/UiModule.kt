package fr.northborders.trendingrepos.ui.di

import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.domain.usecase.GetReadme
import fr.northborders.trendingrepos.domain.usecase.GetRepos
import fr.northborders.trendingrepos.domain.usecase.Markdown
import fr.northborders.trendingrepos.ui.screens.repodetail.RepoDetailPresenter
import fr.northborders.trendingrepos.ui.screens.repos.ReposPresenter
import javax.inject.Singleton

@Module
class UiModule {
    @Provides @Singleton
    fun providesReposPresenter(getRepos: GetRepos): ReposPresenter =
        ReposPresenter(getRepos)

    @Provides @Singleton
    fun providesRepoDetailPresenter(getReadme: GetReadme, markdown: Markdown): RepoDetailPresenter =
        RepoDetailPresenter(getReadme, markdown)
}