package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.ui.theme.AppTheme
import com.haznedar.myvocabularynotebook.ui.theme.RedVisne

@Composable
fun AcademiaPage(){

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.dimens.grid_4 * 2)
                .background(color = RedVisne)
        ) {

            Text(
                text = stringResource(R.string.akademi),
                color = Color.White, fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}