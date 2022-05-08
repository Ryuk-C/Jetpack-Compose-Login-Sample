package com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.util

class LoginUtils {

    //Mail Değerlerin boş olması 2
    //Email uzunluğunun yetersiz olması 3
    //Uygunsuz Mail Formatı 4
    //Şifre Değerlerin boş olması 5

    fun loginFormatValidation(email: String, password: String): Int {

        if (email.trim().isNotEmpty()) {

            if (email.length > 5) {

                if (email.contains("@")) {

                    return if (password.trim().isNotEmpty()) {

                        1

                    } else {


                        5

                    }


                } else {

                    return 4

                }


            } else {

                return 3

            }

        } else {

            return 2

        }
    }
}