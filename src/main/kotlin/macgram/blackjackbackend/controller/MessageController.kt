package macgram.blackjackbackend.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chatMessage: ChatMessage?): ChatMessage? {
        println(chatMessage.toString())
        return chatMessage
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage: ChatMessage, headerAccessor: SimpMessageHeaderAccessor): ChatMessage? {
        println(chatMessage.toString())
        headerAccessor.sessionAttributes!!["username"] = chatMessage.sender
        return chatMessage
    }
}

data class ChatMessage (
    var type: MessageType,
    var content: String?,
    var sender: String
)


// MessageType.kt
enum class MessageType {
    CHAT,
    JOIN,
    LEAVE
}