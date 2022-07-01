package jp.ac.it_college.std.s21018.news_release_manager.application.service

import jp.ac.it_college.std.s21018.news_release_manager.domain.model.NewsWIthCategoryModel
import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService (
    private val newsRepository: NewsRepository
        ) {
    fun getList(): List<NewsWIthCategoryModel> {
        return newsRepository.findAllWithCategory()
    }

    fun getDetail(newsId: Long): NewsWIthCategoryModel {
        return newsRepository.findWithCategory(newsId) ?: throw IllegalArgumentException("存在しないニュースID: $newsId")
    }
}
