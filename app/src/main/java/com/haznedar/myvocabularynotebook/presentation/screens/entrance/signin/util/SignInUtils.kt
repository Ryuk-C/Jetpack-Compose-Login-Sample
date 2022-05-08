package com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.util

class SignInUtils {

    //Empty Email Area 2
    //Değerlerin uzunluğunun yetersiz olması 3
    //Inappropriate Mail Format 4
    //Empty Password Area 5
    //Passwords don't match 6
    //Password's lenght isn't enought 7

    fun registerFormatValidation(email: String, password: String, passwordTwo: String): Int {

        if (email.trim().isNotEmpty()) {

            if (email.length > 5) {

                if (email.contains("@")) {

                    if (password.trim().isNotEmpty() && passwordTwo.trim().isNotEmpty()) {

                        if (password == passwordTwo) {

                            if (password.length > 7 && passwordTwo.length > 7) {

                                return 1

                            } else {

                                return 7
                            }

                        } else {

                            return 6

                        }

                    } else {

                        return 5

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