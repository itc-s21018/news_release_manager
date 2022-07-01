package jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.CategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.CategoryRepository
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.CategoryMapper
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.deleteByPrimaryKey
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.insert
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.updateByPrimaryKeySelective
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.Category
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val categoryMapper: CategoryMapper
) : CategoryRepository{
    override fun register(category: CategoryModel) {
        categoryMapper.insert(toCategory(category))
    }

    override fun update(id: Long, name: String) {
        categoryMapper.updateByPrimaryKeySelective(Category(id, name))
    }

    override fun delete(id: Long) {
        categoryMapper.deleteByPrimaryKey(id)
    }

    private fun toCategory(model: CategoryModel): Category {
        return Category(model.id, model.name)
    }

}