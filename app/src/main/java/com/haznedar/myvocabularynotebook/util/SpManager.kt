package com.haznedar.myvocabularynotebook.util

import android.content.Context

class SpManager {

    fun setSharedPreference(context: Context, key: Sp, value: String?) {
        val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.putString(key.toString(), value)
        edit.commit()
    }

    fun getSharedPreference(context: Context, key: Sp, defaultValue: String?): String? {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
            .getString(key.toString(), defaultValue)
    }

    fun clearSharedPreference(context: Context) {
        val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.clear()
        edit.commit()
    }

    fun removeSharedPreference(context: Context, key: Sp) {
        val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.remove(key.toString())
        edit.commit()
    }

    enum class Sp {
        USERNAME,
        PASSWORD,
        USERID,
        THEME
    }
}