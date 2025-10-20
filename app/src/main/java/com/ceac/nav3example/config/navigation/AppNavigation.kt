package com.ceac.nav3example.config.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceac.nav3example.ui.screens.*

@Composable
fun AppNavigation() {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = LoginRoute
    ) {
        // ----- Auth -----
        composable<LoginRoute> {
            LoginScreen(
                onGoRegister = { nav.navigate(RegisterRoute) },
                onGoRecover  = { nav.navigate(RecoverRoute) },
                onLogged     = { nav.navigateToHomeClearingAuth() }
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(onGoLogin = { nav.popBackStack() })
        }

        composable<RecoverRoute> {
            RecoverPassScreen(onGoLogin = { nav.popBackStack() })
        }

        // ----- Home -----
        composable<HomeRoute> {
            HomeScreen(nav)
        }

        // ----- Product Detail Route -----
        composable<ProductDetailRoute> { entry ->
            ProductDetailScreen(entry)   // dentro haces entry.toRoute<ProductDetailRoute>()
        }

        /* Ejemplo futuro con args:
        composable<ProfileRoute> { entry ->
            // val args = entry.toRoute<ProfileRoute>() // según API disponible
            // ProfileScreen(userId = args.userId)
        }
        */
    }
}

/* ---------- Helpers mínimos (siguen siendo 2 archivos en /navigation) ---------- */

private fun NavController.navigateToHomeClearingAuth() {
    navigate(HomeRoute) {
        popUpTo<LoginRoute> { inclusive = true } // limpia Login del backstack
    }
}
