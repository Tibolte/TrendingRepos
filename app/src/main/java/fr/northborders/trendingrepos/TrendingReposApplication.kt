package fr.northborders.trendingrepos

import android.app.Application
import fr.northborders.trendingrepos.data.di.DataModule
import fr.northborders.trendingrepos.domain.di.DomainModule
import fr.northborders.trendingrepos.ui.di.UiModule

class TrendingReposApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .dataModule(DataModule()).domainModule(DomainModule()).uiModule(UiModule()).build()
    }
}
