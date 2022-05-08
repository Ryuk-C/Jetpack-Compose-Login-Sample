package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.viewmodel.ListViewModel
import com.haznedar.myvocabularynotebook.ui.theme.*
import com.haznedar.myvocabularynotebook.util.Constants
import com.haznedar.myvocabularynotebook.util.SpManager
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun ListPage(
    navController: NavController? = null,
    viewModel: ListViewModel = hiltViewModel()
) {

    val languagesState = viewModel.stateLanguage.value

    val wordsState = viewModel.stateWords.value

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val userID = SpManager().getSharedPreference(context, SpManager.Sp.USERID, "").toString()

    var selectedLanguageIndex by remember {
        mutableStateOf(-1)
    }

    if (selectedLanguageIndex == -1) {

        selectedLanguageIndex = languagesState.defaultLanguageID

    }

    if (languagesState.success == 1) {

        if (selectedLanguageIndex != -1) {

            LaunchedEffect(key1 = Unit) {

                viewModel.getAllWords(
                    Constants.WORDS,
                    Constants.TYPETWO,
                    selectedLanguageIndex.toString(),
                    userID
                )

            }
        }
    }

    LaunchedEffect(key1 = Unit) {

        viewModel.getAllLanguages(Constants.LANGUAGES, Constants.TYPETWO, userID)

    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name),
                    color = Color.White) },

                actions = {

                    IconButton(onClick = { }) {

                        Icon(painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Kelime Ara", tint = Color.White)
                    }

                    TopAppBarDropdownMenu()

                },

                backgroundColor = RedVisne,
                modifier = Modifier.height(AppTheme.dimens.grid_4 * 2)
            )

        },

        floatingActionButton = {

            FloatingActionButton(onClick = {},
            backgroundColor = RedVisne,
                ) {

                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add a New Word", tint = Color.White )

            }

        }

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundGrayColor)
        ) {

            when (languagesState.success) {

                0 -> {

                }

                1 -> {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp)
                            .background(color = BackgroundGrayColor)
                    ) {

                        items(languagesState.languageList.size) {

                            Card(elevation = 2.dp,
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(1.dp, CardGrayColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, end = 5.dp)
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable {

                                            selectedLanguageIndex =
                                                languagesState.languageList[it].kullaniciDilID.toInt()

                                            scope.launch {

                                                viewModel.getAllWords(
                                                    Constants.WORDS,
                                                    Constants.TYPETWO,
                                                    selectedLanguageIndex.toString(),
                                                    userID
                                                )
                                            }
                                        }
                                        .background(
                                            if (selectedLanguageIndex == languagesState.languageList[it].kullaniciDilID.toInt()) Blue
                                            else Color.White
                                        )) {

                                    GlideImage(

                                        modifier = Modifier
                                            .width(35.dp)
                                            .height(32.dp),

                                        //imageModel = Constants.LANGUAGES + languagesState.languageList[it].icon,
                                        imageModel = Constants.LanguageImagePath+languagesState.languageList[it].icon,
                                        // Crop, Fit, Inside, FillHeight, FillWidth, None
                                        contentScale = ContentScale.Crop,
                                        // shows an image with a circular revealed animation.

                                        // shows a placeholder ImageBitmap when loading.

                                        //placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),

                                        // shows an error ImageBitmap when the request failed.

                                        //error = ImageBitmap.imageResource(R.drawable.error)
                                    )

                                    Text(
                                        modifier = Modifier.padding(
                                            start = 5.dp,
                                            end = 7.dp,
                                        ),
                                        text = languagesState.languageList[it].dilAd,
                                        color = if (selectedLanguageIndex == languagesState.languageList[it].kullaniciDilID.toInt()) Color.White
                                        else Color.Black,
                                        fontSize = 18.sp
                                    )


                                }


                            }
                        }
                    }

                }

                2 -> {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        EmptyLangugeList()

                    }

                }

            }

            when (wordsState.success) {

                0 -> {


                }

                1 -> {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
                            .background(color = BackgroundGrayColor)
                    ) {

                        items(wordsState.wordsList.size) {

                            Card(
                                elevation = 2.dp,
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.dp, CardGrayColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            ) {

                                Column(
                                    modifier = Modifier
                                        .background(color = Color.White)
                                        .fillMaxWidth()
                                        .clickable {
                                            //Car Tıklama
                                        }
                                ) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {

                                        Column(
                                            modifier = Modifier
                                                .background(color = Color.White)
                                        ) {

                                            Text(
                                                text = wordsState.wordsList[it].anaKelime,
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(
                                                    start = 7.dp,
                                                    top = 8.dp
                                                )
                                            )

                                            Text(
                                                text = wordsState.wordsList[it].karsilikKelime,
                                                fontSize = 14.sp,
                                                fontStyle = FontStyle.Italic,
                                                modifier = Modifier.padding(
                                                    start = 7.dp,
                                                    top = 4.dp,
                                                    bottom = 8.dp
                                                )
                                            )

                                        }
                                    }
                                }
                            }
                        }
                    }

                }

                2 -> {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp)
                    ) {

                        EmptyWordList()

                    }


                }

            }
        }
    }
}

@Composable
fun EmptyLangugeList() {

    val compositionLoading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_empty_language_list))
    val progressLoading by animateLottieCompositionAsState(
        composition = compositionLoading,
        isPlaying = true,
        speed = 0.70f,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever
    )


    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        LottieAnimation(
            composition = compositionLoading, progress = progressLoading, modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(start = 50.dp, end = 50.dp)
        )

        Text(
            text = stringResource(R.string.dil_bulunamadi),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = {


            },

            shape = RoundedCornerShape(40),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Blue
            ),

            modifier = Modifier
                .padding(top = 20.dp)
        ) {

            Text(
                text = stringResource(R.string.add_language),
                fontSize = 23.sp,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )

        }

    }
}

@Composable
fun EmptyWordList() {

    val compositionLoading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_empty_word_list))
    val progressLoading by animateLottieCompositionAsState(
        composition = compositionLoading,
        isPlaying = true,
        speed = 0.70f,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever
    )


    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        LottieAnimation(
            composition = compositionLoading, progress = progressLoading, modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(start = 50.dp, end = 50.dp)
        )

        Text(
            text = stringResource(R.string.kelime_bulunamadi),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
                .fillMaxWidth()
        )

    }

}

@Composable
fun TopAppBarDropdownMenu() {

    val expanded = remember { mutableStateOf(false) } // 1

    Box(
        Modifier
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = {
            expanded.value = true // 2
            // bodyContent.value =  "Menu Opening"
        }) {
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = "Drop Down Menu",
                tint = Color.White
            )
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
    ) {
        DropdownMenuItem(onClick = {
            expanded.value = false // 3
            //bodyContent.value = "First Item Selected"  // 4
        }) {
            Text(stringResource(R.string.yeni_dil_ekle))
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Second Item Selected"
        }) {
            Text(stringResource(R.string.sort_words))
        }

        //Divider()

        /*
        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Third Item Selected"
        }) {
            Text("Third item")
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Fourth Item Selected"
        }) {
            Text("Fourth item")
        }

         */
    }
}