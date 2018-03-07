package fr.northborders.trendingrepos

import dagger.Component
import fr.northborders.trendingrepos.data.di.DataModule
import fr.northborders.trendingrepos.domain.di.DomainModule
import fr.northborders.trendingrepos.ui.di.UiModule
import fr.northborders.trendingrepos.ui.screens.repodetail.view.RepoDetailFragment
import fr.northborders.trendingrepos.ui.screens.repos.view.ReposFragment
import javax.inject.Singleton

@Component(modules = arrayOf(DataModule::class, DomainModule::class, UiModule::class))
@Singleton
interface AppComponent {
    fun inject(reposFragment: ReposFragment)

    fun inject(repoDetailFragment: RepoDetailFragment)
}
