package fr.northborders.trendingrepos.ui.factory

import fr.northborders.trendingrepos.domain.factory.DataFactory
import fr.northborders.trendingrepos.domain.factory.UserFactory
import fr.northborders.trendingrepos.domain.model.Repo
import fr.northborders.trendingrepos.ui.model.RepoViewModel

class RepoViewModelFactory {
    companion object {
        fun makeRepo(): Repo {
            return Repo(
                DataFactory.randomLong(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                UserFactory.makeUser()
            )
        }

        fun makeRepoViewModel(): RepoViewModel {
            return RepoViewModel(
                DataFactory.randomLong(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomBoolean(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                UserViewModelFactory.makeUserViewModel()
            )
        }

        fun makeRepoViewModelList(count: Int): List<RepoViewModel> {
            val repoEntityList = mutableListOf<RepoViewModel>()
            repeat(count) {
                repoEntityList.add(makeRepoViewModel())
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