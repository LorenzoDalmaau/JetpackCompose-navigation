package com.ceac.nav3example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape

private val DarkScheme = darkColorScheme(
    primary            = PurplePrimary,
    onPrimary          = PurpleOnPrimary,
    primaryContainer   = PurpleContainer,
    onPrimaryContainer = PurpleOnContainer,

    secondary          = CyanSecondary,
    onSecondary        = CyanOnSecondary,
    secondaryContainer = CyanContainer,
    onSecondaryContainer = CyanOnContainer,

    tertiary           = PinkTertiary,
    onTertiary         = PinkOnTertiary,
    tertiaryContainer  = PinkContainer,
    onTertiaryContainer = PinkOnContainer,

    background         = Bg,
    onBackground       = Color(0xFFE5E7EB),

    surface            = SurfaceDark,
    onSurface          = Color(0xFFE5E7EB),
    surfaceVariant     = SurfaceVariantDark,
    onSurfaceVariant   = Color(0xFFB8C2D1),

    outline            = OutlineDark,
    outlineVariant     = OutlineVariantDark,

    error              = Error,
    onError            = Color.White,

    inverseSurface     = InverseSurface,
    inverseOnSurface   = InverseOnSurface,
    scrim              = Scrim
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Forzamos dark porque es una app gamer; si quieres dinámico, cambia aquí.
    val colorScheme = DarkScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = Shapes(
            extraSmall = RoundedCornerShape(8),
            small      = RoundedCornerShape(12),
            medium     = RoundedCornerShape(16),
            large      = RoundedCornerShape(20),
            extraLarge = RoundedCornerShape(28)
        ),
        content = content
    )
}
