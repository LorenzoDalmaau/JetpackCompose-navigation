package com.ceac.nav3example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ceac.nav3example.config.navigation.LoginRoute
import com.ceac.nav3example.config.navigation.ProductDetailRoute
import com.ceac.nav3example.data.repository.ProductRepository
import com.ceac.nav3example.ui.components.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(nav: NavController? = null) {
    val products = ProductRepository.getAll()

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = { Text("Productos") },
                actions = {
                    IconButton(onClick = {
                        nav?.navigate(LoginRoute) { popUpTo(0) { inclusive = true } }
                    }) { Icon(Icons.Outlined.Logout, contentDescription = "Salir") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(products) { p ->
                ProductItem(
                    product = p,
                    onClick = { nav?.navigate(ProductDetailRoute(id = it.id)) }
                )
            }
        }
    }
}
