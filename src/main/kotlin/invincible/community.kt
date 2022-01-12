package invincible


open class Community
data class SendbirdCommunity(val name: String, val channelInfo: String) : Community()
data class GetStreamCommunity(val name: String) : Community()