package jp.ac.it_college.std.s21018.news_release_manager.presetation.controller


import jp.ac.it_college.std.s21018.news_release_manager.application.service.NewsService
import jp.ac.it_college.std.s21018.news_release_manager.presetation.form.GetNewsDetailResponse
import jp.ac.it_college.std.s21018.news_release_manager.presetation.form.GetNewsListResponse
import jp.ac.it_college.std.s21018.news_release_manager.presetation.form.NewsInfo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("news")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")

class NewsController(
    private val newsService: NewsService
) {
    @GetMapping("/list")
    fun getList(): GetNewsListResponse {
        val newsList = newsService.getList().map {
            NewsInfo(it)
        }
        return GetNewsListResponse(newsList)
    }

    @GetMapping("/detail/{news_id}")
    fun getDetail(@PathVariable("news_id") newsId: Long) : GetNewsDetailResponse {
        val news = newsService.getDetail(newsId)
        return GetNewsDetailResponse(news)
    }
}


