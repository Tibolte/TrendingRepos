package fr.northborders.trendingrepos.ui.di

import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.domain.usecase.GetRepos
import fr.northborders.trendingrepos.ui.ReposPresenter
import javax.inject.Singleton

@Module
class UiModule {
    @Provides @Singleton
    fun providesReposPresenter(getRepos: GetRepos): ReposPresenter =
        ReposPresenter(getRepos)

}