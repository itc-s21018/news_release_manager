package jp.ac.it_college.std.s21018.news_release_manager.presetation.handler

import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class NewsManagerAccessDeniedHandler : AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: AccessDeniedException?,
    ) {
        response?.apply {
            status = HttpServletResponse.SC_FORBIDDEN
        }
    }
}

