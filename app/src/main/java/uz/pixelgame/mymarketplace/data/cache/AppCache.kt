package uz.pixelgame.mymarketplace.data.cache

import android.content.Context
import android.content.SharedPreferences

class AppCache private constructor(context: Context) {
    private val keyIsSigned = "KEY_IS_SIGNED"
    private val keyName = "KEY_NAME"
    private val keySurname = "KEY_SURNAME"
    private val keyPhone = "KEY_PHONE"

    init {
        sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)
    }

    companion object {
        private var appCache: AppCache? = null
        private var sharedPreferences: SharedPreferences? = null

        fun init(context: Context) {
            if (appCache == null) {
                appCache = AppCache(context)
            }
        }

        fun getObject(): AppCache {
            return appCache!!
        }
    }

    fun setSigned(isSigned: Boolean) {
        sharedPreferences!!.edit().putBoolean(keyIsSigned, isSigned).apply()
    }

    fun getSigned(): Boolean {
        return sharedPreferences!!.getBoolean(keyIsSigned, false)
    }

    fun setName(name: String) {
        sharedPreferences!!.edit().putString(keyName, name).apply()
    }

    fun getName(): String {
        return sharedPreferences!!.getString(keyName, "empty")!!
    }

    fun setSurname(surname: String) {
        sharedPreferences!!.edit().putString(keySurname, surname).apply()
    }

    fun getSurname(): String {
        return sharedPreferences!!.getString(keySurname, "empty")!!
    }

    fun setNumber(number: String) {
        sharedPreferences!!.edit().putString(keyPhone, number).apply()
    }

    fun getNumber(): String {
        return sharedPreferences!!.getString(keyPhone, "empty")!!
    }

}