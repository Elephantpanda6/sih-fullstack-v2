package com.example.sihscrap.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Factory
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoleSelectionScreen(
    onCollectorClick: () -> Unit,
    onRecyclerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // The EcoSetu signature green gradient background
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF2E7D32), // Dark Green
            Color(0xFF81C784)  // Light Green
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                Text(
                    text = "Welcome to",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "EcoSetu",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            // Language Button
            Surface(
                color = Color(0xFFC5E1A5), // Light yellowish-green
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Language,
                        contentDescription = "Language",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "EN | हिन्दी | मराठी",
                        color = Color(0xFF2E7D32),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Cards Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Collector Card
            RoleCard(
                modifier = Modifier.weight(1f),
                title = "COLLECTOR",
                hindiSubtitle = "कलेक्टर",
                marathiSubtitle = "कलेक्टर",
                description = "I collect materials /\nकबाड़ इकट्ठा करें",
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = Color.White
                    )
                },
                onClick = onCollectorClick
            )

            // Recycler Card
            RoleCard(
                modifier = Modifier.weight(1f),
                title = "RECYCLER",
                hindiSubtitle = "रीसायकलर",
                marathiSubtitle = "रीसायकलर",
                description = "I process waste /\nभंगार पुनर्प्राप्त करें",
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Factory,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = Color.White
                    )
                },
                onClick = onRecyclerClick
            )
        }
    }
}

@Composable
fun RoleCard(
    modifier: Modifier = Modifier,
    title: String,
    hindiSubtitle: String,
    marathiSubtitle: String,
    description: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(300.dp)
            .shadow(12.dp, RoundedCornerShape(24.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFF388E3C) // Solid Green Card
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = hindiSubtitle,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp
                )
                Text(
                    text = marathiSubtitle,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 16.sp
                )
            }
            
            // Image Placeholder (Using passed icon for now)
            icon()

            Text(
                text = description,
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
        }
    }
}
