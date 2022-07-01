package jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.CategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.model.NewsModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.model.NewsWIthCategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.mapper.*
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.News
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.NewsWithCategory
import org.springframework.stereotype.Repository

@Repository
class NewsRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWithCategory(): List<NewsWIthCategoryModel> {
        return newsWithCategoryMapper.select().map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWIthCategoryModel? {
        return newsWithCategoryMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toCategory(news))
    }



    private fun toModel(record: NewsWithCategory): NewsWIthCategoryModel {
        val news = NewsModel(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.body!!,
            record.userId!!
        )


        val category = record.id?.let {
            CategoryModel(
                record.id!!,
                record.name!!
            )
        }
        return NewsWIthCategoryModel(news, category)
    }

    private fun toCategory(model: News) : News {
        return News(model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body)
    }
}
