package fr.northborders.trendingrepos.ui.factory

import fr.northborders.trendingrepos.domain.factory.DataFactory
import fr.northborders.trendingrepos.domain.model.User
import fr.northborders.trendingrepos.ui.UserViewModel

class UserViewModelFactory {
    companion object {
        fun makeUser(): User  {
            return User(
                DataFactory.randomString(),
                DataFactory.randomInt(),
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
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                true,
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt()
            )
        }

        fun makeUserViewModel(): UserViewModel {
            return UserViewModel(
                DataFactory.randomString(),
                DataFactory.randomInt(),
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
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                true,
                DataFactory.randomInt(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomString(),
                DataFactory.randomInt(),
                DataFactory.randomInt()
            )
        }
    }
}