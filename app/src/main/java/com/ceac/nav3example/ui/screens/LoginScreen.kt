package com.ceac.nav3example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ceac.nav3example.ui.components.*

@Composable
fun LoginScreen(
    onGoRegister: () -> Unit,
    onGoRecover: () -> Unit,
    onLogged: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var pass  by rememberSaveable { mutableStateOf("") }
    val canGo = email.isNotBlank() && pass.length >= 6

    AuthScaffold(
        title = "Bienvenido",
        subtitle = "Inicia sesión para continuar",
        bottomText = {
            Row {
                GhostTextButton("¿No tienes cuenta? Regístrate", onGoRegister)
                Spacer(Modifier.width(8.dp))
                GhostTextButton("Olvidé mi contraseña", onGoRecover)
            }
        }
    ) {
        EmailField(email, { email = it }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(12.dp))
        PasswordField(pass, { pass = it }, onDone = { if (canGo) onLogged() }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        PrimaryButton(
            text = "Entrar",
            onClick = onLogged,
            enabled = canGo,
            modifier = Modifier.fillMaxWidth()
        )
        if (!canGo) {
            Spacer(Modifier.height(8.dp))
            Text(
                "La contraseña debe tener al menos 6 caracteres.",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
