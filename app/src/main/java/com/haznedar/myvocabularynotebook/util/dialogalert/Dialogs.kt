package com.haznedar.myvocabularynotebook.util.dialogalert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.haznedar.myvocabularynotebook.ui.theme.ErrorColor
import com.haznedar.myvocabularynotebook.ui.theme.Shapes
import com.haznedar.myvocabularynotebook.ui.theme.SuccessColor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.haznedar.myvocabularynotebook.R

@Composable
fun SuccessDialog(
    title:String,
    desc : String,
    processText : String,
    onDismiss: () -> Unit,
    onProcess: () -> Unit
){
    Dialog(onDismissRequest = onDismiss) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)){

            Column {

                Spacer(modifier = Modifier.height(30.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )){

                    Column(modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(text = title,
                            style = TextStyle(color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold))

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = desc,
                            style = TextStyle(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal))

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Button(onClick = onDismiss,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = ErrorColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = stringResource(R.string.iptal), color = Color.White)

                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick =  onProcess,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = SuccessColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = processText, color = Color.White)

                            }

                        }

                    }

                }

            }

            SuccessHeader(
                Modifier
                    .size(72.dp)
                    .align(Alignment.TopCenter)
                    .border(
                        border = BorderStroke(width = 5.dp, color = Color.White),
                        shape = CircleShape
                    )
            )

        }
    }

}

@Composable
fun ErrorDialog(
    title:String,
    desc : String,
    processText : String,
    onDismiss: () -> Unit,
    onProcess: () -> Unit
){
    Dialog(onDismissRequest = onDismiss) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)){

            Column {

                Spacer(modifier = Modifier.height(30.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )){

                    Column(modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(text = title,
                            style = TextStyle(color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold))

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = desc,
                            style = TextStyle(
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal))

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Button(onClick = onDismiss,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = ErrorColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = stringResource(R.string.iptal), color = Color.White)

                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick =  onProcess,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = SuccessColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = processText, color = Color.White)

                            }

                        }

                    }

                }

            }

            ErrorHeader(
                Modifier
                    .size(72.dp)
                    .align(Alignment.TopCenter)
                    .border(
                        border = BorderStroke(width = 5.dp, color = Color.White),
                        shape = CircleShape
                    )
            )

        }
    }

}

@Composable
fun InfoDialog(
    title:String,
    desc : String,
    processText : String,
    onDismiss: () -> Unit,
    onProcess: () -> Unit
){
    Dialog(onDismissRequest = onDismiss) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)){

            Column {

                Spacer(modifier = Modifier.height(30.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )){

                    Column(modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(text = title,
                            style = TextStyle(color = Color.Black,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold))

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = desc,
                            style = TextStyle(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal))

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Button(onClick = onDismiss,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = ErrorColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = stringResource(R.string.iptal), color = Color.White)

                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick =  onProcess,
                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = SuccessColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {

                                Text(text = processText, color = Color.White)

                            }

                        }

                    }

                }

            }

            InfoHeader(
                Modifier
                    .size(72.dp)
                    .align(Alignment.TopCenter)
                    .border(
                        border = BorderStroke(width = 5.dp, color = Color.White),
                        shape = CircleShape
                    )
            )

        }
    }

}



@Composable
fun CustomDialogAlert(
    type: CustomDialogType,
    title: String,
    desc: String,
    processText: String,
    onDismiss: () -> Unit,
    onProcess: () -> Unit,
) {

    when (type) {

        CustomDialogType.SUCCESS -> {

            SuccessDialog(
                title = title,
                desc = desc,
                processText = processText,
                onDismiss = onDismiss,
                onProcess
            )

        }

        CustomDialogType.ERROR -> {

            ErrorDialog(
                title = title,
                desc = desc,
                processText = processText,
                onDismiss = onDismiss,
                onProcess
            )

        }

        CustomDialogType.INFO -> {

            InfoDialog(
                title = title,
                desc = desc,
                processText = processText,
                onDismiss = onDismiss,
                onProcess = onProcess
            )

        }

    }


}

enum class CustomDialogType {
    SUCCESS, ERROR, INFO
}