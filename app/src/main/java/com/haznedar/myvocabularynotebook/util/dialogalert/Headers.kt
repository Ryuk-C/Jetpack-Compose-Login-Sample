package com.haznedar.myvocabularynotebook.util.dialogalert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.haznedar.myvocabularynotebook.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SuccessHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_success))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)

}

@Composable
fun ErrorHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_error))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)

}


@Composable
fun InfoHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_info))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)
}