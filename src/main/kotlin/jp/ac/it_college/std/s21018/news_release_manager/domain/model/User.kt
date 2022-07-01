package jp.ac.it_college.std.s21018.news_release_manager.domain.model

import jp.ac.it_college.std.s21018.news_release_manager.domain.enum.RoleType

data class User(
    var id: Long,
    var username: String,
    var password: String,
    var viewName: String,
    var roleType: RoleType
)
