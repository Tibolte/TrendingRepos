package fr.northborders.trendingrepos.ui.factory

import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomInt
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomString
import fr.northborders.trendingrepos.domain.model.RepoContent
import fr.northborders.trendingrepos.ui.model.RepoContentViewModel

class RepoContentViewModelFactory {
    companion object {
        fun makeRepoContent(): RepoContent =
            RepoContent(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )

        fun makeRepoContentViewModel(): RepoContentViewModel =
            RepoContentViewModel(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )
    }
}