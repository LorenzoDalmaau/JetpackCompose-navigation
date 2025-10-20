package com.ceac.nav3example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ceac.nav3example.ui.components.*

@Composable
fun RecoverPassScreen(onGoLogin: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    val snack = remember { SnackbarHostState() }

    AuthScaffold(
        title = "Recuperar acceso",
        subtitle = "Te enviaremos un email con instrucciones",
        bottomText = { GhostTextButton("Volver a Login", onGoLogin) }
    ) {
        EmailField(email, { email = it }, modifier = Modifier.fillMaxWidth(), ime = androidx.compose.ui.text.input.ImeAction.Done)
        Spacer(Modifier.height(16.dp))
        PrimaryButton(
            text = "Enviar enlace",
            onClick = { /* simular */ onGoLogin() },
            enabled = email.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(4.dp))
        SnackbarHost(snack)
    }
}
