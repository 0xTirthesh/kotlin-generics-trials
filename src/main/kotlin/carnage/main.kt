package carnage

import com.google.gson.JsonObject
import com.google.gson.JsonParser


fun main(args: Array<String>) {
    val str = """
        {
            "cards": [
                {
                    "widget_type": "MINI_MANDIR",
                    "cta": {
                        "text": "Mandir Staphit Karein!",
                        "icon_type": null,
                        "btn_type": "ONLY_TEXT",
                        "action_type": "GO_TO_MANDIR"
                    },
                    "items": [
                        { "url": "img-1.jpg" },
                        { "url": "img-2.jpg" },
                        { "url": "img-3.jpg" },
                        { "url": "img-4.jpg" }
                    ]
                },
                {
                    "widget_type": "ACTION_CARDS",
                    "items": [
                        {
                            "title": "Mandir ka shank bajaaye!",
                            "image": { url : "shankh.jpg" },
                            "cta": {
                                "text": null,
                                "icon_type": null,
                                "btn_type": "NONE",
                                "action_type": "PLAY_SHELL"
                            }
                        },
                        {
                            "title": "Mandir ka ghanta bajaaye!",
                            "image": { url : "bell.jpg" },
                            "cta": {
                                "text": null,
                                "icon_type": null,
                                "btn_type": "NONE",
                                "action_type": "PLAY_BELL"
                            }
                        },
                        {
                            "title": "Aaj ka shubhmantra sune!",
                            "image": { url : "song-thumb.jpg" },
                            "cta": {
                                "text": null,
                                "icon_type": null,
                                "btn_type": "NONE",
                                "action_type": "PLAY_SONG",
                                "action_attrs": {
                                    "r_song_id": "123"
                                }
                            }
                        }
                    ]
                }
            ]
        }
    """.trimIndent()

    val response: JsonObject = JsonParser.parseString(str).asJsonObject
    val cardList = (response["cards"]).asJsonArray
    cardList.mapNotNull {
        it as JsonObject // type casting as jsonObject to
        val widgetTypeStr = it["widget_type"].asString
        val widgetType = WidgetType::str.find(widgetTypeStr)!! // make a better check here; raise valid exception
        println("Widget Type: ${widgetTypeStr} >> ${widgetType}")
        parseCardFromMap(widgetType, it).apply {
            println(this)
        }
    }

}