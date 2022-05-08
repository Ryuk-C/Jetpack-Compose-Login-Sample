package com.haznedar.myvocabularynotebook.UtilClassUnitTest

import com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.util.SignInUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SignInUtilTest {

    private lateinit var SignInUtils: SignInUtils

    @Before
    fun setup() {

        SignInUtils = SignInUtils()

    }

    @Test
    fun `all value true return 1`() {

        val username = "info@haznedar.de"
        val passwordOne = "Şifre12345"
        val passwordTwo = "Şifre12345"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(1, result)

    }

    @Test
    fun `value of username are empty return 2`() {

        val username = "   "
        val passwordOne = "Şifre12345"
        val passwordTwo = "Şifre12345"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(2, result)
    }

    @Test
    fun `short leng username format return 3`() {

        val username = "haz"
        val passwordOne = "Şifre12345"
        val passwordTwo = "Şifre12345"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(3, result)
    }

    @Test
    fun `bad username format return 4`() {

        val username = "infohaznedar.de"
        val passwordOne = "Şifre12345"
        val passwordTwo = "Şifre12345"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(4, result)
    }

    @Test
    fun `value of passwords are empty return 5`() {

        val username = "info@haznedar.de"
        val passwordOne = "   "
        val passwordTwo = "   "

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `value of passwords weren't same return 6`() {

        val username = "info@haznedar.de"
        val passwordOne = "haznedar"
        val passwordTwo = "haznedar2"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(6, result)
    }

    @Test
    fun `value of passwords weren't short return 7`() {

        val username = "info@haznedar.de"
        val passwordOne = "hazned"
        val passwordTwo = "hazned"

        val result = SignInUtils.registerFormatValidation(username, passwordOne, passwordTwo)
        Assert.assertEquals(7, result)
    }

}