package jp.ac.it_college.std.s21018.news_release_manager.presetation.handler

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class NewsManagerAuthenticationSuccessHandler : AuthenticationSuccessHandler{
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?,
    ) {
        response?.apply {
            status = HttpServletResponse.SC_OK
        }
    }
}

