package carnage

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

enum class WidgetType(val str: String) {
    MINI_MANDIR("MINI_MANDIR"),
    ACTION_CARDS("ACTION_CARDS"),
    ;
}

open class Card(
    @SerializedName("widget_type") val widgetType: WidgetType
)

// MiniMandir carnage.Card
data class MiniMandirCard(val items: List<ImageAttachment>, val cta: Cta) : Card(WidgetType.MINI_MANDIR)

// carnage.ActionCard
data class ActionCardItem(val title: String, val image: ImageAttachment, val cta: Cta) : Card(WidgetType.ACTION_CARDS)

data class ActionCard(val items: List<ActionCardItem>) : Card(WidgetType.ACTION_CARDS)


fun parseCardFromMap(widgetType: WidgetType, data: JsonObject): Card {
    val gson = Gson()
    val card = when (widgetType) {
        //carnage.WidgetType.MINI_MANDIR -> gson.fromJson(data, carnage.MiniMandirCard::class.java)
        WidgetType.MINI_MANDIR -> data.toObject<MiniMandirCard>()
        WidgetType.ACTION_CARDS -> data.toObject<ActionCard>()
    }
    return card
}