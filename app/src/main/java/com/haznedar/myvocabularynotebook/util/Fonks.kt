package com.haznedar.myvocabularynotebook.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

suspend fun internetCheck(): Boolean = withContext(Dispatchers.IO)
{

    val runTime = Runtime.getRuntime()

    try {

        val ipProcess = runTime.exec("/system/bin/ping -c 1 www.google.com")
        val exitValue: Int = ipProcess.waitFor()
        return@withContext (exitValue == 0)

    } catch (e: IOException) {

        e.printStackTrace()

    } catch (e: InterruptedException) {

        e.printStackTrace()
    }

    return@withContext false
}