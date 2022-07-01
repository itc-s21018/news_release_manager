package jp.ac.it_college.std.s21018.news_release_manager.presetation.config

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

@EnableRedisHttpSession
class HttpSessionConfig {
    @Bean
    fun connectionFactory(): JedisConnectionFactory {
        return JedisConnectionFactory()
    }
}

