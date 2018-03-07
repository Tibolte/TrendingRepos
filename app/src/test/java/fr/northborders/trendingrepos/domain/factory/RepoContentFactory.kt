package fr.northborders.trendingrepos.domain.factory

import fr.northborders.trendingrepos.data.model.RepoContentEntity

import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomInt
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomString
import fr.northborders.trendingrepos.domain.model.RepoContent

class RepoContentFactory {
    companion object {
        fun makeRepoContentEntity(): RepoContentEntity {
            return RepoContentEntity(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )
        }

        fun makeRepoContent(): RepoContent {
            return RepoContent(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )
        }
    }
}
