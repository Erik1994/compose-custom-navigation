package com.example.composecustomnavigation.features

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.UUID

@Composable
fun HomeScreen(
    onDetailClick: (String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { onDetailClick(UUID.randomUUID().toString()) }) {
            Text(text = "Go to Detail")
        }
    }
}