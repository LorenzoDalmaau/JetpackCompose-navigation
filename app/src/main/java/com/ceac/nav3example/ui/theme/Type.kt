package com.ceac.nav3example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.ceac.nav3example.R

private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Inter + JetBrains Mono para numeritos/códigos
private val inter = GoogleFont("Inter")
private val interRegular  = Font(googleFont = inter, fontProvider = provider, weight = FontWeight.Normal)
private val interMedium   = Font(googleFont = inter, fontProvider = provider, weight = FontWeight.Medium)
private val interSemibold = Font(googleFont = inter, fontProvider = provider, weight = FontWeight.SemiBold)
private val interBold     = Font(googleFont = inter, fontProvider = provider, weight = FontWeight.Bold)

val AppTypography = Typography(
    displayLarge  = TextStyle(fontFamily = FontFamily(interBold),     fontSize = 40.sp, lineHeight = 44.sp, letterSpacing = (-0.25).sp),
    displayMedium = TextStyle(fontFamily = FontFamily(interBold),     fontSize = 34.sp, lineHeight = 38.sp),
    headlineLarge = TextStyle(fontFamily = FontFamily(interSemibold), fontSize = 28.sp, lineHeight = 32.sp),
    headlineMedium= TextStyle(fontFamily = FontFamily(interSemibold), fontSize = 24.sp, lineHeight = 28.sp),
    titleLarge    = TextStyle(fontFamily = FontFamily(interSemibold), fontSize = 20.sp, lineHeight = 26.sp),
    titleMedium   = TextStyle(fontFamily = FontFamily(interSemibold), fontSize = 16.sp, lineHeight = 22.sp),
    bodyLarge     = TextStyle(fontFamily = FontFamily(interRegular),  fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium    = TextStyle(fontFamily = FontFamily(interRegular),  fontSize = 14.sp, lineHeight = 20.sp),
    labelLarge    = TextStyle(fontFamily = FontFamily(interMedium),   fontSize = 14.sp, lineHeight = 16.sp),
    labelMedium   = TextStyle(fontFamily = FontFamily(interMedium),   fontSize = 12.sp, lineHeight = 14.sp)
)
