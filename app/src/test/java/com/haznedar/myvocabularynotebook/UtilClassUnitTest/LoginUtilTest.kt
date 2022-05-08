package com.haznedar.myvocabularynotebook.UtilClassUnitTest

import com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.util.LoginUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginUtilTest{

    private lateinit var LoginUtils : LoginUtils

    @Before
    fun setup(){
        LoginUtils = LoginUtils()
    }

    @Test
    fun `all value are true return 1`(){

        val username = "cuma@haznedar.de"
        val password = "Şifre123"

        val result = LoginUtils.loginFormatValidation(username,password)
        Assert.assertEquals(1, result)

    }

    @Test
    fun `value of username was empty return 2`(){

        val username = "   "
        val password = "Şifre123"

        val result = LoginUtils.loginFormatValidation(username,password)
        Assert.assertEquals(2, result)

    }

    @Test
    fun `lengt of username was short return 3`(){

        val username = "cuma"
        val password = "Şifre123"

        val result = LoginUtils.loginFormatValidation(username,password)
        Assert.assertEquals(3, result)

    }

    @Test
    fun `format of username was bad return 4`(){

        val username = "infohaznedar"
        val password = "Şifre123"

        val result = LoginUtils.loginFormatValidation(username,password)
        Assert.assertEquals(4, result)

    }

    @Test
    fun `value of passworf was empty return 5`(){

        val username = "info@haznedar.de"
        val password = "    "

        val result = LoginUtils.loginFormatValidation(username,password)
        Assert.assertEquals(5, result)

    }

}