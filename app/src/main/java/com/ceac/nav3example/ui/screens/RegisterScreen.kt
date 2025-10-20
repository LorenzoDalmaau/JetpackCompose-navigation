package com.ceac.nav3example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ceac.nav3example.ui.components.*

@Composable
fun RegisterScreen(onGoLogin: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var pass  by rememberSaveable { mutableStateOf("") }
    var pass2 by rememberSaveable { mutableStateOf("") }

    val valid = email.isNotBlank() && pass.length >= 6 && pass == pass2

    AuthScaffold(
        title = "Crear cuenta",
        subtitle = "Solo te llevará un minuto",
        bottomText = { GhostTextButton("¿Ya tienes cuenta? Inicia sesión", onGoLogin) }
    ) {
        EmailField(email, { email = it }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(12.dp))
        PasswordField(pass, { pass = it }, label = "Contraseña", modifier = Modifier.fillMaxWidth(), ime = androidx.compose.ui.text.input.ImeAction.Next)
        Spacer(Modifier.height(12.dp))
        PasswordField(pass2, { pass2 = it }, label = "Repite contraseña", modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Crear cuenta", onClick = onGoLogin, enabled = valid, modifier = Modifier.fillMaxWidth())
    }
}
