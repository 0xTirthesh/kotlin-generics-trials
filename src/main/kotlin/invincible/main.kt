package invincible

import java.time.LocalDate

fun getClient(code: String): ApiClient<out Community, out Message> =
    when (code) {
        "sb" -> SendbirdApiClient()
        "gs" -> GetStreamApiClient()
        else -> throw Error("err-invalid-code")
    }


fun main(args: Array<String>) {
    val code = if (args.isEmpty()) "gs" else args[0]
    val user = User("123")

    if (code == "sb") {
        val client = getClient(code) as SendbirdApiClient
        client.connect(user)
        val community = SendbirdCommunity("hello", "sb_channel")
        client.joinCommunity(community)

        val message = SendbirdMessage(SendbirdMessageType.Admin, "some admin message", null)
        client.sendMessages(message)
    } else {
        val client = getClient(code) as GetStreamApiClient
        client.connect(user)
        val community = GetStreamCommunity("hello")
        client.joinCommunity(community)

        val message = GetStreamMessage("some admin message", listOf("some-image.jpg"), LocalDate.now())
        client.sendMessages(message)
    }
}