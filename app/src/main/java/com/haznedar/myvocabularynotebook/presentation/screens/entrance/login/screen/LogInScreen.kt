package com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.screen

import android.content.Intent
import android.provider.Settings
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.SCAFFOLD_GRAPH_ROUTE
import com.haznedar.myvocabularynotebook.presentation.navigation.tool.ScreenList
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.util.LoginUtils
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.viewmodel.LoginViewModel
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.screen.LoadingAnimation
import com.haznedar.myvocabularynotebook.ui.theme.AppTheme
import com.haznedar.myvocabularynotebook.ui.theme.LoginScreenTheme
import com.haznedar.myvocabularynotebook.ui.theme.RedVisne
import com.haznedar.myvocabularynotebook.util.Constants
import com.haznedar.myvocabularynotebook.util.dialogalert.CustomDialogAlert
import com.haznedar.myvocabularynotebook.util.dialogalert.CustomDialogType
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun LoginPage(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
    email: String? = null
) {

    val state = viewModel.state.value

    val context = LocalContext.current

    val intent = remember {
        Intent(Settings.ACTION_WIRELESS_SETTINGS)
    }

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    val username = remember {
        mutableStateOf("")
    }

    if (email != null && email != "Null") {

        LaunchedEffect(key1 = Unit) {

            username.value = email

        }
    }

    val password = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    val isErrorEmailIcon = remember {
        mutableStateOf(false)
    }

    val isErrorEmailMessage = remember {
        mutableStateOf("Null")
    }

    val isErrorPasswordMessage = remember {
        mutableStateOf("Null")
    }

    val infoDialog = remember {
        mutableStateOf(false)
    }

    if (infoDialog.value) {
        CustomDialogAlert(
            type = CustomDialogType.INFO,
            title = stringResource(R.string.bilgi),
            desc = stringResource(R.string.kullanici_bulunamadi),
            processText = stringResource(R.string.uye_ol),

            onProcess = {

                infoDialog.value = false

                scope.launch {

                    delay(150)

                    viewModel.clearViewModel()

                    navController.navigate(ScreenList.SignInScreen.withArgs(username.value))

                }

            },

            onDismiss = {

                viewModel.clearViewModel()

                infoDialog.value = false

            },


            )
    }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    when (state.success) {


        0 -> {


        }

        1 -> {

            LaunchedEffect(key1 = Unit) {

                navController.navigate(SCAFFOLD_GRAPH_ROUTE) {

                    popUpTo("Login_Screen") { inclusive = true }

                }
            }
        }

        202 -> {

            infoDialog.value = true

            state.success = -1

        }

        203 -> {

            infoDialog.value = true

            state.success = -1

        }
    }


    LoginScreenTheme {

        Scaffold(

            scaffoldState = scaffoldState,
            snackbarHost = {

                SnackbarHost(it) {
                    Snackbar(
                        backgroundColor = Color.Red,
                        contentColor = Color.White,
                        actionColor = Color.White,
                        snackbarData = it
                    )
                }

            },
            content = {

                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

                    Column {

                        Column(
                            modifier = Modifier
                                .weight(1.3f)
                                .fillMaxWidth()
                        ) {

                            GlideImage(

                                modifier = Modifier
                                    .fillMaxWidth(),

                                imageModel = Constants.LoginImagePath,

                                contentScale = ContentScale.FillBounds,

                            )

                        }

                        Column(
                            modifier = Modifier
                                .weight(2.7f)
                                .fillMaxWidth()
                                .offset(y = -30.dp)
                                .background(
                                    color = Color.White,
                                    RoundedCornerShape(
                                        topStart = AppTheme.dimens.grid_5,
                                        topEnd = AppTheme.dimens.grid_5
                                    )
                                )
                        ) {

                            Row(
                                horizontalArrangement = Arrangement.Center, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = AppTheme.dimens.grid_2_5)
                            ) {

                                Text(
                                    text = stringResource(R.string.hos_geldiniz),
                                    color = RedVisne,
                                    fontSize = 29.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize()
                            ) {

                                Column(modifier = Modifier) {

                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5,
                                                end = AppTheme.dimens.grid_3_5,
                                                top = AppTheme.dimens.grid_4
                                            ),
                                        value = username.value,
                                        onValueChange = { username.value = it },
                                        label = {
                                            Text(
                                                text = stringResource(R.string.username),
                                                color = Color.Black
                                            )
                                        },
                                        colors = if (!isErrorEmailIcon.value) TextFieldDefaults.outlinedTextFieldColors(

                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = RedVisne,
                                            cursorColor = RedVisne,
                                            focusedBorderColor = Color.Black,
                                            unfocusedBorderColor = Color.Gray

                                        ) else TextFieldDefaults.outlinedTextFieldColors(

                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = RedVisne,
                                            cursorColor = RedVisne,
                                            focusedBorderColor = Color.Red,
                                            unfocusedBorderColor = Color.Red
                                        ),

                                        leadingIcon = {

                                            IconButton(onClick = {


                                            }) {

                                                Icon(
                                                    imageVector = Icons.Filled.Email,
                                                    contentDescription = "E-Mail İcon"
                                                )

                                            }
                                        },

                                        keyboardOptions = KeyboardOptions(

                                            keyboardType = KeyboardType.Email,
                                            imeAction = ImeAction.Next
                                        ),

                                        trailingIcon = {

                                            if (isErrorEmailIcon.value)
                                                Icon(
                                                    Icons.Filled.Warning,
                                                    contentDescription = "E-Mail Error Icon",
                                                    tint = MaterialTheme.colors.error
                                                )
                                        }
                                    )

                                    if (isErrorEmailIcon.value) {
                                        Text(
                                            text = isErrorEmailMessage.value,
                                            color = MaterialTheme.colors.error,
                                            style = MaterialTheme.typography.caption,
                                            modifier = Modifier.padding(
                                                top = AppTheme.dimens.grid_1,
                                                start = AppTheme.dimens.grid_3_5
                                            )
                                        )
                                    }

                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5,
                                                end = AppTheme.dimens.grid_3_5,
                                                top = AppTheme.dimens.grid_2
                                            ),
                                        value = password.value,
                                        onValueChange = { password.value = it },
                                        label = {
                                            Text(
                                                text = stringResource(R.string.password),
                                                color = Color.Black
                                            )
                                        },

                                        colors = if (isErrorPasswordMessage.value == "Null")

                                            TextFieldDefaults.outlinedTextFieldColors(
                                                backgroundColor = Color.White,
                                                textColor = Color.Black,
                                                leadingIconColor = RedVisne,
                                                focusedBorderColor = Color.Black,
                                                unfocusedBorderColor = Color.Gray
                                            )
                                        else TextFieldDefaults.outlinedTextFieldColors(
                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = RedVisne,
                                            focusedBorderColor = Color.Red,
                                            unfocusedBorderColor = Color.Red
                                        ),

                                        leadingIcon = {

                                            IconButton(onClick = {

                                            }) {

                                                Icon(
                                                    imageVector = Icons.Filled.Lock,
                                                    contentDescription = "Password İcon"
                                                )

                                            }
                                        },

                                        trailingIcon = {

                                            IconButton(onClick = {

                                                passwordVisibility = !passwordVisibility

                                            }) {

                                                Icon(
                                                    painter = icon,
                                                    contentDescription = "Password İcon"
                                                )

                                            }

                                        },

                                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                                        else PasswordVisualTransformation(),

                                        singleLine = true,

                                        keyboardOptions = KeyboardOptions(

                                            keyboardType = KeyboardType.Password,
                                            imeAction = ImeAction.Done,
                                        ),

                                        keyboardActions = KeyboardActions(

                                            onDone = {

                                                keyboardController?.hide()

                                            }
                                        )
                                    )

                                    if (isErrorPasswordMessage.value != "Null") {
                                        Text(
                                            text = isErrorPasswordMessage.value,
                                            color = MaterialTheme.colors.error,
                                            style = MaterialTheme.typography.caption,
                                            modifier = Modifier.padding(
                                                top = AppTheme.dimens.grid_1,
                                                start = AppTheme.dimens.grid_3_5
                                            )
                                        )
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End, modifier = Modifier
                                            .padding(
                                                top = AppTheme.dimens.grid_1_5,
                                                end = AppTheme.dimens.grid_3_5
                                            )
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            text = stringResource(R.string.sifremi_unuttum),
                                            color = Color.Gray
                                        )

                                    }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5 * 2,
                                                end = AppTheme.dimens.grid_3_5 * 2,
                                                top = AppTheme.dimens.grid_1_5 * 2
                                            ),
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Button(
                                            onClick = {

                                                when (LoginUtils().loginFormatValidation(
                                                    username.value,
                                                    password.value
                                                )) {

                                                    1 -> {

                                                        viewModel.getUserLogin(
                                                            Constants.LOGIN,
                                                            Constants.TYPETWO,
                                                            username.value,
                                                            password.value
                                                        )

                                                    }

                                                    2 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.lutfen_email_girin)

                                                    }

                                                    3 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.email_cok_kisa)

                                                    }

                                                    4 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.uyumsuz_mail_formati)

                                                    }

                                                    5 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorEmailMessage.value = "Null"
                                                        isErrorPasswordMessage.value =
                                                            context.getString(R.string.lutfen_sifrenizi_giriniz)

                                                    }
                                                }
                                            },
                                            shape = RoundedCornerShape(AppTheme.dimens.grid_4),
                                            modifier = Modifier
                                                .fillMaxWidth(),

                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = RedVisne,
                                                contentColor = Color.White
                                            )

                                        ) {

                                            Text(

                                                text = stringResource(R.string.login),
                                                fontSize = 18.sp,
                                                modifier = Modifier
                                                    .padding(
                                                        top = AppTheme.dimens.grid_1,
                                                        bottom = AppTheme.dimens.grid_1
                                                    )

                                            )
                                        }
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {

                                        if (state.isLoading) {

                                            LoadingAnimation(speed = 4f)

                                        }
                                    }
                                }

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.Bottom,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {

                                    Text(text = stringResource(R.string.hesabiniz_yokmu))

                                    Spacer(modifier = Modifier.padding(AppTheme.dimens.grid_0_5))

                                    Text(text = stringResource(R.string.uye_ol),
                                        color = RedVisne,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .clickable {

                                                scope.launch {

                                                    viewModel.clearViewModel()

                                                    navController.navigate(
                                                        ScreenList.SignInScreen.withArgs(
                                                            "Null"
                                                        )
                                                    )

                                                }
                                            }
                                    )
                                }
                            }
                        }
                    }

                    if (state.internet) {

                        LaunchedEffect(key1 = Unit) {

                            scope.launch {

                                val sb = scaffoldState.snackbarHostState.showSnackbar(
                                    context.getString(R.string.no_internet_connection),
                                    actionLabel = context.getString(R.string.ayarlar),
                                    duration = SnackbarDuration.Long
                                )

                                if (sb == SnackbarResult.ActionPerformed) {

                                    context.startActivity(intent)

                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    
   // LoginPage(navController = rememberNavController(), viewModel = hiltViewModel(), "")
    
}
