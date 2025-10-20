package com.ceac.nav3example.config.navigation

import kotlinx.serialization.Serializable

// Auth
@Serializable data object LoginRoute
@Serializable data object RegisterRoute
@Serializable data object RecoverRoute

// Home (lista de productos)
@Serializable data object HomeRoute

// Detalle de producto (pasamos solo el id)
@Serializable data class ProductDetailRoute(val id: String)


/* Ejemplo para el futuro (args tipados):
@Serializable data class ProfileRoute(val userId: Long)
*/
