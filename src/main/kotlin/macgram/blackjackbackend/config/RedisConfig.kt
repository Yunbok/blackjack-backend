package macgram.blackjackbackend.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer

@Configuration
class RedisConfig {

    @Bean
    fun connectionFactory(@Value("\${spring.data.redis.url}") url: String): LettuceConnectionFactory {
        val redisConfiguration = LettuceConnectionFactory.createRedisConfiguration(url)

        return LettuceConnectionFactory(redisConfiguration)
    }

    @Bean
    fun <T> redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, T> {
        val redisTemplate = RedisTemplate<String, T>()
        redisTemplate.keySerializer = RedisSerializer.string()
        redisTemplate.valueSerializer = GenericJackson2JsonRedisSerializer()

        redisTemplate.setConnectionFactory(redisConnectionFactory)
        return redisTemplate
    }
}
