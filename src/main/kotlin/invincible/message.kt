package invincible

import java.time.LocalDate


open class Message

enum class SendbirdMessageType {
    Text,
    File,
    Admin,
    ;
}

data class SendbirdMessage(
    val type: SendbirdMessageType,
    val text: String?,
    val attachments: List<String>?
) : Message()

data class GetStreamMessage(
    val text: String,
    val attachments: List<String>?,
    val createdOn: LocalDate
) : Message()