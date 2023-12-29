package macgram.blackjackbackend.serivce

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import macgram.blackjackbackend.domain.room.Room
import macgram.blackjackbackend.domain.user.Player
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RoomService(val redisTemplate: RedisTemplate<String, Any>) {
    fun create(creator: Player) {
        val room = Room(creator)
        redisTemplate.opsForValue().set("room", room)
    }

    fun getRoom(room: String): Any? {
        return redisTemplate.opsForValue().get("room")
    }

}
