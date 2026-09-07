package com.example.sihscrap.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.sihscrap.R

@Composable
fun RoleSelectionScreen(
    onCollectorClick: () -> Unit,
    onRecyclerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        // The cropped PNG image serves as the entire UI
        Image(
            painter = painterResource(id = R.drawable.role_selection_bg),
            contentDescription = "Role Selection Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay transparent clickable boxes over the Collector and Recycler cards
        // The cards are roughly side-by-side in the middle of the screen
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp, bottom = 100.dp) // Approximate vertical bounds of the cards
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(onClick = onCollectorClick)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(onClick = onRecyclerClick)
            )
        }
    }
}
