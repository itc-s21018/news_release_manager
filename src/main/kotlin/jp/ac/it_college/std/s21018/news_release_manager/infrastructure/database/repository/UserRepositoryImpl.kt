package jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.UserRepository
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.UsersDynamicSqlSupport
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.UsersMapper
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.selectOne
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.Users
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UsersMapper,
) : UserRepository {
    override fun find(email: String): Users? {
        val record = mapper.selectOne {
            where {
                UsersDynamicSqlSupport.users.username isEqualTo email
            }
        }
        return record?.let { toModel(it) }
    }

    private fun toModel(record: Users) : Users {
        return Users(
            record.id!!,
            record.username!!,
            record.password!!,
            record.viewName!!,
            record.roleType!!
        )
    }
}