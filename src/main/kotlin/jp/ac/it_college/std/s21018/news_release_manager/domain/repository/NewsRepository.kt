package jp.ac.it_college.std.s21018.news_release_manager.domain.repository

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.NewsWIthCategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.News

interface NewsRepository {
    fun findAllWithCategory(): List<NewsWIthCategoryModel>

    fun findWithCategory(id: Long): NewsWIthCategoryModel?

    fun register(news: News)

}