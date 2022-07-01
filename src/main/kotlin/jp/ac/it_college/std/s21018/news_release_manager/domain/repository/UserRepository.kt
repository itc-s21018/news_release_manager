package jp.ac.it_college.std.s21018.news_release_manager.domain.repository

import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.Users

interface UserRepository {
    fun find(email: String) : Users?
}

