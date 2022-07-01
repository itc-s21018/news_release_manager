package jp.ac.it_college.std.s21018.news_release_manager.application.service

import jp.ac.it_college.std.s21018.news_release_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.News
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional



@Service
class AdminNewsService(
    private val newsRepository: NewsRepository
) {
    @Transactional
    fun register(news: News) {
        newsRepository.findWithCategory(news.id!!)?.let {
            throw IllegalArgumentException("すでに存在するニュースID: ${news.id}")
        }
        newsRepository.register(news)
    }
}