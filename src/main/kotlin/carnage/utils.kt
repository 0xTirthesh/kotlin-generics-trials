package carnage

import com.google.gson.Gson
import com.google.gson.JsonObject

inline fun <reified T : Enum<T>, V> ((T) -> V).find(value: V): T? {
    return enumValues<T>().firstOrNull { this(it) == value }
}

interface JSONConvertable {
    fun toJSON(): String = Gson().toJson(this)
}

inline fun <reified T> JsonObject.toObject(): T = Gson().fromJson(this, T::class.java)
inline fun <reified T> String.toObject(): T = Gson().fromJson(this, T::class.java)