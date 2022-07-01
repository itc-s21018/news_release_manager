package jp.ac.it_college.std.s21018.news_release_manager.domain.model

import java.time.LocalDateTime

data class NewsModel(
    var id: Long,
    var title: String,
    var categoryId: Long,
    var publishAt: LocalDateTime,
    var createAt: LocalDateTime,
    var body: String,
    var userId: Long
)
