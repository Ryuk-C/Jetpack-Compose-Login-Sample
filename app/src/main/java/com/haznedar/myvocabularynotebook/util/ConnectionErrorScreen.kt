package com.haznedar.myvocabularynotebook.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.screen.LoadingAnimation
import com.haznedar.myvocabularynotebook.ui.theme.RedVisne
import kotlinx.coroutines.launch

@Composable
fun NoConnectionPage(
    navController: NavController? = null,
) {

    val scope = rememberCoroutineScope()

    val internetProcess = remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 1.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "Wifi Connection is unsucces."
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = stringResource(R.string.whoops), fontSize = 28.sp)

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = stringResource(R.string.internet_baglantisi_bulunamadi), fontSize = 16.sp)

        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = stringResource(R.string.lutfen_internetinizi_kontrol_edin),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,

            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.padding(15.dp))

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp),
            shape = RoundedCornerShape(25.dp),

            onClick = {

                scope.launch {

                    try {

                        internetProcess.value = true

                        when (!internetCheck()) {

                            false -> {
                                // delay(800)
                                internetProcess.value = false

                                navController?.navigate(ScreenList.SplashScreen.withArgs()) {

                                    popUpTo("No_Connection_Screen") {
                                        inclusive = true
                                    } // Sayfayı back stackden silme

                                }

                                //navController?.popBackStack()

                            }

                            true -> {
                                //  delay(800)
                                internetProcess.value = false

                            }

                        }


                    } catch (e: Exception) {


                    }
                }
            },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = RedVisne,
                contentColor = Color.White
            )

        ) {

            Text(
                text = stringResource(R.string.tekrar_dene), fontSize = 18.sp, modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            )

        }

        if (internetProcess.value == true) {

            LoadingAnimation(speed = 5f)

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    NoConnectionPage()

}