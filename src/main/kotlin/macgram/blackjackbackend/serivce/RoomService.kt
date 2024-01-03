package macgram.blackjackbackend.serivce

import macgram.blackjackbackend.domain.room.Room
import macgram.blackjackbackend.domain.user.Player
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RoomService(val redisTemplate: RedisTemplate<String, Room>) {
    fun create(creator: Player) {
        val room = Room(creator)
        redisTemplate.opsForValue().set("room", room)
    }

    fun getRoom(room: String): Room {
        return redisTemplate.opsForValue().get("room")!!
    }

}
