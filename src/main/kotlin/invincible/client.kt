package invincible

interface ApiClient<C : Community, M : Message> {
    fun connect(user: User)
    fun joinCommunity(community: C)
    fun sendMessages(message: M)
}

class SendbirdApiClient : ApiClient<SendbirdCommunity, SendbirdMessage> {
    override fun connect(user: User) {
        println("Connecting user with id '${user.r_user_id}' with SendBird")
    }

    override fun joinCommunity(community: SendbirdCommunity) {
        println("Joining community '${community.name}' using SendBird APIs")
    }

    override fun sendMessages(message: SendbirdMessage) {
        println("Sending message ${message.text} using SendBird APIs")
    }
}

class GetStreamApiClient : ApiClient<GetStreamCommunity, GetStreamMessage> {
    override fun connect(user: User) {
        println("Connecting user with id '${user.r_user_id}' with GetStream APIs")
    }

    override fun joinCommunity(community: GetStreamCommunity) {
        println("Joining community '${community.name}' using GetStream APIs")
    }


    override fun sendMessages(message: GetStreamMessage) {
        println("Sending message '${message.text}' using GetStream APIs")
    }
}