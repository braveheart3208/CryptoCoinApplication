package com.appsolute.coinapp.presentation.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 18/12/2023, Monday
 **/

data class Dimensions(
    val default : Dp = 0.dp,
    val divider : Dp = 1.dp,
    val spaceXS : Dp = 4.dp,
    val spaceS : Dp = 8.dp,
    val spaceM : Dp = 16.dp,
    val spaceL : Dp = 32.dp,
    val spaceXL : Dp = 64.dp,
    val defaultRoundedCornerRatio : Dp = 10.dp,
)

val LocalSpacing = compositionLocalOf { Dimensions() }