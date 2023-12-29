package macgram.blackjackbackend.config

import io.lettuce.core.RedisURI
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {

    @Bean
    fun connectionFactory(@Value("\${spring.data.redis.url}") url: String): LettuceConnectionFactory {
        val redisConfiguration = LettuceConnectionFactory.createRedisConfiguration(url)

        return LettuceConnectionFactory(redisConfiguration)
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.setConnectionFactory(redisConnectionFactory)

        return redisTemplate
    }
}
