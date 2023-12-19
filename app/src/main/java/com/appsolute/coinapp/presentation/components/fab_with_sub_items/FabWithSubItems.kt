package com.appsolute.coinapp.presentation.components.fab_with_sub_items

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.appsolute.coinapp.presentation.ui.theme.LocalSpacing

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 18/12/2023, Monday
 **/

sealed interface FabState {
    object Expanded : FabState
    object Collapsed : FabState
}

data class SubItem(
    val id : String,
    val icon: ImageBitmap,
    val label: String,
)

@Composable
fun FabSubItem(
    item: SubItem,
    onItemClicked: (SubItem) -> Unit
) {
    val buttonColor = MaterialTheme.colorScheme.secondary

    Canvas(
        modifier = Modifier
            .size(64.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                onClick = {
                    onItemClicked(item)
                },
                indication = rememberRipple(
                    bounded = false,
                    radius = 20.dp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
    ) {
        drawCircle(
            color = buttonColor,
            radius = 64f,
        )

        drawImage(
            image = item.icon,
            topLeft = Offset(
                center.x - item.icon.width / 2,
                center.y - item.icon.width / 2
            )
        )
    }
}

@Composable
fun FabWithSubItems(
    initialState: FabState,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    subItems: List<SubItem>,
    onSubItemClicked : (SubItem) -> Unit
) {
    val spacing = LocalSpacing.current

    var iconState by remember {
        mutableStateOf(initialState)
    }

    Column(horizontalAlignment = Alignment.End) {
        if (iconState == FabState.Expanded) {
            subItems.forEach { item ->
                FabSubItem(
                    item = item,
                    onItemClicked = onSubItemClicked
                )
            }
        }

        FloatingActionButton(
            onClick = {
                iconState = if (iconState == FabState.Expanded) {
                    FabState.Collapsed
                } else {
                    FabState.Expanded
                }
            },
            shape = RoundedCornerShape(spacing.defaultRoundedCornerRatio),
            containerColor = backgroundColor,
            contentColor = contentColor,
        ) {
            if (iconState == FabState.Expanded) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = null)
            } else {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }
        }
    }
}