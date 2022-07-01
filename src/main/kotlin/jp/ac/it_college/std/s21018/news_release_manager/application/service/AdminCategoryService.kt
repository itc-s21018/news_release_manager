package jp.ac.it_college.std.s21018.news_release_manager.application.service

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.CategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminCategoryService(
    private val categoryRepository: CategoryRepository
){
    @Transactional
    fun register(category: CategoryModel) {
        categoryRepository.register(category)
    }

    @Transactional
    fun update(category: CategoryModel) {
        categoryRepository.update(category.id, category.name)
    }

    @Transactional
    fun delete(categoryId: Long) {
        categoryRepository.delete((categoryId))
    }
}