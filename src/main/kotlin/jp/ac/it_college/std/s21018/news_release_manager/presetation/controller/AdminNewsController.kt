package jp.ac.it_college.std.s21018.news_release_manager.presetation.controller

import jp.ac.it_college.std.s21018.news_release_manager.application.service.AdminNewsService
import jp.ac.it_college.std.s21018.news_release_manager.application.service.security.NewsManagerUserDetails
import jp.ac.it_college.std.s21018.news_release_manager.infrastructure.database.record.News
import jp.ac.it_college.std.s21018.news_release_manager.presetation.form.RegisterNewsRequest
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("admin/news")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class AdminNewsController (
    private val adminNewsService: AdminNewsService,
    ) {
        @PostMapping("/register")
        fun register(@RequestBody request: RegisterNewsRequest, authentication: Authentication) {
            val pribcipal = authentication.name as NewsManagerUserDetails
            adminNewsService.register(
                News(
                    0,
                    request.title,
                    request.categoryId,
                    request.publishAt,
                    LocalDateTime.now(),
                    1,
                    request.body
                )
            )
        }
    }
