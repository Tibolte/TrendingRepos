package fr.northborders.trendingrepos.domain.factory

import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomInt
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomString
import fr.northborders.trendingrepos.data.model.UserEntity
import fr.northborders.trendingrepos.domain.model.User

class UserFactory {
    companion object {
        fun makeUserEntity(): UserEntity  {
            return UserEntity(
                randomString(),
                randomInt(),
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
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                true
            )
        }

        fun makeUser(): User {
            return User(
                randomString(),
                randomInt(),
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
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                true
            )
        }
    }
}
