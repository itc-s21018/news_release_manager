package jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record

import java.time.LocalDateTime

data class NewsWithCategory(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null,
    val name: String?

)
