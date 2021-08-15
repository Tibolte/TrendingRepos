package fr.northborders.trendingrepos.domain.factory

import fr.northborders.trendingrepos.data.model.RepoEntity
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomBoolean
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomInt
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomLong
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomString
import fr.northborders.trendingrepos.domain.model.Repo

class RepoFactory {
    companion object {
        fun makeRepoEntity(): RepoEntity {
            return RepoEntity(
                randomLong(),
                randomString(),
                randomString(),
                randomBoolean(),
                randomString(),
                randomString(),
                randomBoolean(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomString(),
                randomInt(),
                randomString(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomString(),
                randomInt(),
                UserFactory.makeUserEntity()
            )
        }

        fun makeRepo(): Repo {
            return Repo(
                randomLong(),
                randomString(),
                randomString(),
                randomBoolean(),
                randomString(),
                randomString(),
                randomBoolean(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomString(),
                randomInt(),
                randomString(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomInt(),
                randomString(),
                randomInt(),
                UserFactory.makeUser()
            )
        }

        fun makeRepoEntityList(count: Int): List<RepoEntity> {
            val repoEntityList = mutableListOf<RepoEntity>()
            repeat(count) {
                repoEntityList.add(makeRepoEntity())
            }
            return repoEntityList
        }

        fun makeRepoList(count: Int): List<Repo> {
            val repoList = mutableListOf<Repo>()
            repeat(count) {
                repoList.add(makeRepo())
            }
            return repoList
        }
    }
}