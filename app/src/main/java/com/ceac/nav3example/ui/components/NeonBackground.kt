// ui/components/NeonBackground.kt
package com.ceac.nav3example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme

@Composable
fun NeonBackground(content: @Composable () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            // FONDO OSCURO DEL TEMA
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Glow morado arriba-izquierda
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color(0x332B00FF), // morado con alpha
                            Color.Transparent
                        ),
                        center = androidx.compose.ui.geometry.Offset(0f, 0f),
                        radius = 900f
                    )
                )
                .blur(50.dp)
        )
        // Glow cian abajo-derecha
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color(0x3300E5FF), // cian con alpha
                            Color.Transparent
                        ),
                        center = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY),
                        radius = 900f
                    )
                )
                .blur(60.dp)
        )
        content()
    }
}
