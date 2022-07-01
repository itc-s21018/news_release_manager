package jp.ac.it_college.std.s21018.news_release_manager.domain.repository

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.CategoryModel

interface CategoryRepository {
    fun register(category: CategoryModel)

    fun update(id: Long, name: String)

    fun delete(id: Long)
}

