package carnage

import com.google.gson.annotations.SerializedName

data class ImageAttachment(val url: String)

enum class BtnType(val str: String) {
    TEXT_ONLY("TEXT_ONLY"),
    ICON_ONLY("ICON_ONLY"),
    TEXT_WITH_ICON("TEXT_WITH_ICON"),
    NONE("NONE"),
    ;
}

enum class IconType(val str: String) {
    PLAY_ICON("PLAY_ICON"),
    BELL_ICON("BELL_ICON"),
    ;
}

enum class ActionType(val str: String) {
    PLAY_BELL("PLAY_BELL"),
    PLAY_SONG("PLAY_SONG"),
    PLAY_SHELL("PLAY_SHELL"),
    GO_TO_MANDIR("GO_TO_MANDIR"),
    ;
}

data class Cta(
    @SerializedName("btn_type") val btnType: BtnType,
    @SerializedName("text") val text: String?,
    @SerializedName("icon_type") val iconType: IconType?,
    @SerializedName("action_type") val actionType: ActionType,
    @SerializedName("action_attrs") val actionAttr: Map<String, Any>
)
