package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.viewmodel.SettingsViewModel
import com.haznedar.myvocabularynotebook.ui.theme.AppTheme
import com.haznedar.myvocabularynotebook.ui.theme.BackgroundGrayColor
import com.haznedar.myvocabularynotebook.ui.theme.BottomGray
import com.haznedar.myvocabularynotebook.ui.theme.RedVisne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun SettingsPage(
    navController: NavController? = null,
    ) {

    val checkedState = remember { mutableStateOf(false) }

    val sendAppLinkIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT, stringResource(R.string.share_app_text) + "\n" + stringResource(
                R.string.play_store_link
            )
        )
        type = "text/plain"
    }

    val sharePlayStoreLink = Intent.createChooser(sendAppLinkIntent, null)

    val sendFeedbackIntent: Intent = Intent().apply {
        action = Intent.ACTION_SENDTO
        data = Uri.parse("mailto:" + stringResource(R.string.haznedar_mail_adress))
        putExtra(Intent.EXTRA_SUBJECT, stringResource(R.string.app_name))
        putExtra(Intent.EXTRA_TEXT, "")
    }

    BottomActionSheet(navController!!) { state, scope, context ->

        Column() {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppTheme.dimens.grid_4 * 2)
                    .background(color = RedVisne)
            ) {

                Text(
                    text = stringResource(id = R.string.ayarlar),
                    color = Color.White, fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = BackgroundGrayColor)
            ) {

                item {

                    Column() {

                        Column() {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {

                                Card(
                                    elevation = AppTheme.dimens.grid_0_5,
                                    shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                                    modifier = Modifier
                                        .padding(
                                            start = AppTheme.dimens.grid_1_5,
                                            end = AppTheme.dimens.grid_1_5,
                                            bottom = AppTheme.dimens.grid_1_5,
                                            top = AppTheme.dimens.grid_2_5
                                        )
                                        .fillMaxWidth()
                                        .clickable {

                                            Log.e("Profile Card", "Tıklandı.")

                                        }

                                ) {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.background(color = Color.White)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(90f)
                                        ) {
                                            Image(
                                                painterResource(id = R.drawable.userprofilepic),
                                                contentDescription = "User Profile Picture",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .padding(
                                                        start = AppTheme.dimens.grid_2,
                                                        AppTheme.dimens.grid_2,
                                                        bottom = AppTheme.dimens.grid_2
                                                    )
                                                    .size(AppTheme.dimens.grid_5 * 2)
                                                    .clip(CircleShape)
                                            )

                                            Column(
                                                modifier = Modifier
                                                    .padding(AppTheme.dimens.grid_1_5)
                                            ) {

                                                Text(
                                                    text = "Wiktoria Stinson",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold
                                                )

                                                Text(
                                                    text = stringResource(R.string.kullanici_bilgilerini_duzenleyin),
                                                    fontSize = 13.sp,
                                                    fontStyle = FontStyle.Italic,
                                                )

                                            }
                                        }

                                        Row(
                                            horizontalArrangement = Arrangement.End,
                                            modifier = Modifier.weight(10f)
                                        ) {

                                            Icon(
                                                painterResource(id = R.drawable.ic_baseline_right),
                                                contentDescription = "",
                                                modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                            )
                                        }
                                    }

                                }
                            }

                            Text(
                                text = stringResource(R.string.icerikler),
                                color = Color.Gray,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(
                                        start = AppTheme.dimens.grid_1_5,
                                        bottom = AppTheme.dimens.grid_1_5
                                    )
                            )

                            Card(
                                elevation = AppTheme.dimens.grid_0_5,
                                shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = AppTheme.dimens.grid_1_5,
                                        end = AppTheme.dimens.grid_1_5,
                                        bottom = AppTheme.dimens.grid_1_5
                                    )
                                    .clickable {

                                        Log.e("Favoriye", "Tıklandı.")

                                    }
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.background(color = Color.White)
                                ) {

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(85f)
                                    ) {

                                        Image(
                                            painterResource(id = R.drawable.ic_favorite),
                                            contentDescription = "Favorite Icon",
                                            modifier = Modifier
                                                .padding(
                                                    start = AppTheme.dimens.grid_2,
                                                    top = AppTheme.dimens.grid_2,
                                                    bottom = AppTheme.dimens.grid_2
                                                )
                                                .size(AppTheme.dimens.grid_4_5)
                                        )

                                        Text(
                                            text = stringResource(R.string.favoriler),
                                            fontSize = 19.sp,
                                            modifier = Modifier
                                                .padding(start = AppTheme.dimens.grid_1_5)
                                        )


                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(15f)
                                    ) {

                                        Icon(
                                            painterResource(id = R.drawable.ic_baseline_right),
                                            contentDescription = "",
                                            modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                        )

                                    }
                                }
                            }

                            Card(
                                elevation = AppTheme.dimens.grid_0_5,
                                shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = AppTheme.dimens.grid_1_5,
                                        end = AppTheme.dimens.grid_1_5,
                                        bottom = AppTheme.dimens.grid_1_5
                                    )
                                    .clickable {
                                        Log.e("Exam", "Tıklandı.")

                                    }
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.background(color = Color.White)
                                ) {

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(85f)
                                    ) {

                                        Image(
                                            painterResource(id = R.drawable.ic_exam),
                                            contentDescription = "Exam Icon",
                                            modifier = Modifier
                                                .padding(
                                                    start = AppTheme.dimens.grid_2,
                                                    top = AppTheme.dimens.grid_2,
                                                    bottom = AppTheme.dimens.grid_2
                                                )
                                                .size(AppTheme.dimens.grid_4_5)
                                        )

                                        Text(
                                            text = stringResource(R.string.sinav_sonuclari),
                                            fontSize = 19.sp,
                                            modifier =
                                            Modifier.padding(
                                                start = AppTheme.dimens.grid_1_5
                                            )
                                        )

                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(15f)
                                    ) {

                                        Icon(
                                            painterResource(id = R.drawable.ic_baseline_right),
                                            contentDescription = "",
                                            modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                        )

                                    }

                                }
                            }

                            Card(
                                elevation = AppTheme.dimens.grid_0_5,
                                shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = AppTheme.dimens.grid_1_5,
                                        end = AppTheme.dimens.grid_1_5,
                                        bottom = AppTheme.dimens.grid_1_5
                                    )
                                    .clickable {
                                        Log.e("Pdf", "Tıklandı.")

                                    }
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.background(color = Color.White)
                                ) {

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(85f)

                                    ) {

                                        Image(
                                            painterResource(id = R.drawable.ic_pdf),
                                            contentDescription = "Pdf Icon",
                                            modifier = Modifier
                                                .padding(
                                                    start = AppTheme.dimens.grid_2,
                                                    top = AppTheme.dimens.grid_2,
                                                    bottom = AppTheme.dimens.grid_2
                                                )
                                                .size(AppTheme.dimens.grid_4_5)
                                        )

                                        Text(
                                            text = stringResource(R.string.pdf_aktar),
                                            fontSize = 19.sp,
                                            modifier =
                                            Modifier.padding(start = AppTheme.dimens.grid_1_5)
                                        )
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier.weight(15f)
                                    ) {

                                        Icon(
                                            painterResource(id = R.drawable.ic_baseline_right),
                                            contentDescription = "",
                                            modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                        )
                                    }
                                }

                            }

                            Card(
                                elevation = AppTheme.dimens.grid_0_5,
                                shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = AppTheme.dimens.grid_1_5,
                                        end = AppTheme.dimens.grid_1_5,
                                        bottom = AppTheme.dimens.grid_1_5
                                    )
                                    .clickable {

                                        Log.e("Excel", "Tıklandı.")
                                    }
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.background(color = Color.White)
                                ) {

                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(85f)
                                    ) {

                                        Image(
                                            painterResource(id = R.drawable.ic_excel),
                                            contentDescription = "Excel Icon",
                                            modifier = Modifier
                                                .padding(
                                                    start = AppTheme.dimens.grid_2,
                                                    top = AppTheme.dimens.grid_2,
                                                    bottom = AppTheme.dimens.grid_2
                                                )
                                                .size(AppTheme.dimens.grid_4_5)
                                        )

                                        Text(
                                            text = stringResource(R.string.excele_aktar),
                                            fontSize = 19.sp,
                                            modifier =
                                            Modifier.padding(
                                                start = AppTheme.dimens.grid_1_5
                                            )
                                        )


                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier.weight(15f)
                                    ) {

                                        Icon(
                                            painterResource(id = R.drawable.ic_baseline_right),
                                            contentDescription = "",
                                            modifier = Modifier.padding(
                                                end =
                                                AppTheme.dimens.grid_1_5
                                            )
                                        )

                                    }

                                }

                            }

                        }

                    }

                    Text(
                        text = stringResource(R.string.tercihler),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(
                            start = AppTheme.dimens.grid_1_5,
                            bottom = AppTheme.dimens.grid_1_5
                        )
                    )

                    Column() {

                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                    Log.e("Arayüz Dili", "Tıklandı.")

                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)
                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_language),
                                        contentDescription = "Language Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.arayuz_dili),
                                        fontSize = 19.sp,
                                        modifier = Modifier.padding(
                                            start = AppTheme.dimens.grid_1_5
                                        )
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "",
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                    )
                                }
                            }

                        }

                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {


                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)

                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_dark_mode),
                                        contentDescription = "Dark Mode Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.dark_mode),
                                        fontSize = 19.sp,
                                        modifier = Modifier
                                            .padding(
                                                AppTheme.dimens.grid_1_5
                                            )
                                    )


                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Switch(
                                        checked = checkedState.value,
                                        onCheckedChange = { checkedState.value = it },
                                        colors = SwitchDefaults.colors(
                                            checkedThumbColor = RedVisne,
                                            checkedTrackColor = Color(0xFFFFA6C9),
                                            uncheckedThumbColor = BackgroundGrayColor
                                            //uncheckedTrackColor = Color(0xFFFFA6C9)
                                        ),
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)

                                    )
                                }
                            }

                        }


                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                    scope.launch {

                                        state.animateTo(ModalBottomSheetValue.Expanded, tween(500))

                                        /*  if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                          bottomSheetScaffoldState.bottomSheetState.expand()
                                      } else {
                                          bottomSheetScaffoldState.bottomSheetState.collapse()
                                      } */
                                    }

                                }
                        ) {

                            BackHandler(

                                enabled = (state.currentValue == ModalBottomSheetValue.HalfExpanded ||
                                        state.currentValue == ModalBottomSheetValue.Expanded),
                                onBack = {

                                    scope.launch {

                                        state.animateTo(ModalBottomSheetValue.Hidden, tween(350))

                                    }
                                })

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)

                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_exit),
                                        contentDescription = "Dark Mode Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.exit_app),
                                        fontSize = 19.sp,
                                        color = Color.Red,
                                        modifier = Modifier
                                            .padding(
                                                AppTheme.dimens.grid_1_5
                                            )
                                    )


                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(end = AppTheme.dimens.grid_1_5)
                                    )

                                }

                            }

                        }

                    }

                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(
                                start = AppTheme.dimens.grid_1_5,
                                bottom = AppTheme.dimens.grid_1_5
                            )
                    )

                    Column() {

                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)
                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_info),
                                        contentDescription = "App About Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.hakkinda), fontSize = 19.sp,
                                        modifier = Modifier.padding(
                                            start = AppTheme.dimens.grid_1_5,

                                            )
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "Ok Icon",
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                    )
                                }
                            }

                        }

                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)
                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_star),
                                        contentDescription = "App About Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.degerlendir),
                                        fontSize = 19.sp,
                                        modifier = Modifier.padding(
                                            AppTheme.dimens.grid_1_5
                                        )
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "Ok Icon",
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                    )
                                }
                            }
                        }

                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {


                                    if (sendFeedbackIntent.resolveActivity(context.packageManager) != null)

                                        context.startActivity(sendFeedbackIntent)
                                    else

                                        Toast
                                            .makeText(
                                                context,
                                                "Mail göndermek için E-Mail uygulaması bulunamadı!",
                                                Toast.LENGTH_LONG
                                            )
                                            .show()
                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)
                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_feedback),
                                        contentDescription = "App About Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.geri_bildirim),
                                        fontSize = 19.sp,
                                        modifier = Modifier.padding(
                                            start = AppTheme.dimens.grid_1_5
                                        )
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "Ok Icon",
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                    )
                                }
                            }
                        }


                        Card(
                            elevation = AppTheme.dimens.grid_0_5,
                            shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = AppTheme.dimens.grid_1_5,
                                    end = AppTheme.dimens.grid_1_5,
                                    bottom = AppTheme.dimens.grid_1_5
                                )
                                .clickable {

                                    context.startActivity(sharePlayStoreLink)

                                }
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(color = Color.White)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(85f)
                                ) {

                                    Image(
                                        painterResource(id = R.drawable.ic_share),
                                        contentDescription = "App About Icon",
                                        modifier = Modifier
                                            .padding(
                                                start = AppTheme.dimens.grid_2,
                                                top = AppTheme.dimens.grid_2,
                                                bottom = AppTheme.dimens.grid_2
                                            )
                                            .size(AppTheme.dimens.grid_4_5)
                                    )

                                    Text(
                                        text = stringResource(R.string.tavsiye_et),
                                        fontSize = 19.sp,
                                        modifier = Modifier.padding(
                                            start = AppTheme.dimens.grid_1_5
                                        )
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.weight(15f)
                                ) {

                                    Icon(
                                        painterResource(id = R.drawable.ic_baseline_right),
                                        contentDescription = "Ok Icon",
                                        modifier = Modifier.padding(end = AppTheme.dimens.grid_1_5)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }


}

@ExperimentalMaterialApi
@Composable
fun BottomActionSheet(
    navController: NavController,
    activityContentScope: @Composable (state: ModalBottomSheetState, scope: CoroutineScope, context: Context) -> Unit
) {

    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    ModalBottomSheetLayout(
        sheetBackgroundColor = Color.White,
        sheetElevation = AppTheme.dimens.grid_0_5,
        sheetShape = RoundedCornerShape(
            topStart = AppTheme.dimens.grid_4,
            topEnd = AppTheme.dimens.grid_4
        ),
        sheetState = state,
        sheetContent = {

            Surface(color = Color.White) {

                ExitFromApp(clickNo = {

                    coroutineScope.launch {

                        Log.e("Hayıra", "Tıklandı.")

                        state.animateTo(ModalBottomSheetValue.Hidden, tween(350))

                    }

                },
                    clickYes = {

                        coroutineScope.launch {

                            Log.e("Evete", "Tıklandı.")

                            // SpManager().removeSharedPreference(context, SpManager.Sp.USERNAME).toString()

                            // SpManager().removeSharedPreference(context, SpManager.Sp.PASSWORD).toString()

                            state.animateTo(ModalBottomSheetValue.Hidden, tween(350))

                        }
                    }
                )
            }

        }) {

        activityContentScope(state, coroutineScope, context)

    }

}

@ExperimentalMaterialApi
@Composable
fun ExitFromApp(clickNo: () -> Unit, clickYes: () -> Unit) {

    val compositionLoading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_exit_from_app))

    val progressLoading by animateLottieCompositionAsState(
        compositionLoading, isPlaying = true,
        speed = 1.5f, restartOnPlay = true, iterations = LottieConstants.IterateForever
    )

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = AppTheme.dimens.grid_2,
                        bottom = AppTheme.dimens.plane_1
                    )
            ) {

                Spacer(
                    modifier = Modifier
                        .width(AppTheme.dimens.grid_4 * 2)
                        .height(AppTheme.dimens.grid_1)
                        .clip(RoundedCornerShape(AppTheme.dimens.grid_4))
                        .background(color = BottomGray)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = AppTheme.dimens.grid_0_5, bottom = AppTheme.dimens.plane_1)
            ) {

                LottieAnimation(
                    compositionLoading, progressLoading, modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.dimens.grid_5 * 5)

                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = AppTheme.dimens.grid_2_5,
                        end = AppTheme.dimens.grid_2_5,
                        bottom = AppTheme.dimens.grid_2
                    )
            )
            {

                Text(
                    text = "Oturumunuzu kapatmak istiyor musunuz?", fontSize = 21.sp,
                    textAlign = TextAlign.Center, modifier = Modifier

                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimens.grid_1_5)
                ) {

                    Button(
                        onClick =
                        clickNo,
                        shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                        modifier = Modifier
                            .weight(50f)
                            .padding(
                                start = AppTheme.dimens.grid_2_5,
                                end = AppTheme.dimens.grid_1_5
                            ),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
                            contentColor = Color.White
                        )
                    )
                    {
                        Text(
                            text = "Hayır",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(
                                top = AppTheme.dimens.plane_1,
                                bottom = AppTheme.dimens.plane_1
                            )
                        )
                    }

                    Button(
                        onClick = clickYes,
                        shape = RoundedCornerShape(AppTheme.dimens.grid_2),
                        modifier = Modifier
                            .weight(50f)
                            .padding(
                                start = AppTheme.dimens.grid_1_5,
                                end = AppTheme.dimens.grid_2_5
                            ),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Green,
                            contentColor = Color.White
                        )
                    )
                    {
                        Text(
                            text = "Evet",
                            fontSize = 18.sp, modifier = Modifier.padding(
                                top = AppTheme.dimens.plane_1,
                                bottom = AppTheme.dimens.plane_1
                            )
                        )
                    }

                }

            }
        }


}

@ExperimentalMaterialApi
@Preview(showBackground = true, locale = "tr")
@Composable
fun DeaultPreview() {

    // SettingsPage(null)

}