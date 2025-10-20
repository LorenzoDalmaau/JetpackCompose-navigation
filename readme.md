# 🧭 Navegación Tipada en Jetpack Compose — Ejemplo Completo

Este proyecto muestra cómo implementar **navegación tipada y segura con rutas** en **Jetpack Compose**, utilizando `@Serializable` para pasar argumentos entre pantallas de forma sencilla, segura y escalable.

---

## 🚀 Descripción general

La aplicación contiene un flujo de autenticación y una sección de productos:

- **Login**, **Registro** y **Recuperar contraseña**.
- Una **pantalla principal (Home)** donde se listan productos.
- Una **pantalla de detalle de producto**, que recibe su `id` por parámetros.
- Navegación segura, sin strings ni errores de rutas mal escritas.

Toda la navegación se gestiona con **rutas tipadas** usando `kotlinx.serialization` y `navigation-compose`.

---

## 📂 Estructura del proyecto

```
com.ceac.nav3example/
 ├─ config/
 │   └─ navigation/
 │        ├─ AppNavigation.kt
 │        └─ Routes.kt
 │
 ├─ data/
 │   ├─ local/
 │   ├─ model/
 │   │    └─ Product.kt
 │   ├─ remote/
 │   └─ repository/
 │        └─ ProductRepository.kt
 │
 ├─ domain/
 │   ├─ model/
 │   ├─ repository/
 │   └─ usercase/
 │
 ├─ ui/
 │   ├─ components/
 │   │    ├─ AppLogo.kt
 │   │    ├─ AuthScaffold.kt
 │   │    ├─ Inputs.kt
 │   │    ├─ NeonBackground.kt
 │   │    └─ ProductItem.kt
 │   │
 │   ├─ screens/
 │   │    ├─ HomeScreen.kt
 │   │    ├─ LoginScreen.kt
 │   │    ├─ ProductDetailsScreen.kt
 │   │    ├─ RecoverPassScreen.kt
 │   │    └─ RegisterScreen.kt
 │   │
 │   └─ theme/
 │        ├─ Color.kt
 │        ├─ Theme.kt
 │        └─ Type.kt
 │
 ├─ MainActivity.kt
 └─ AndroidManifest.xml
```

---

## ⚙️ Navegación por rutas tipadas

### 🔸 Archivo `AppNavigation.kt`

```kotlin
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

        composable<RegisterRoute> { RegisterScreen(onGoLogin = { nav.popBackStack() }) }
        composable<RecoverRoute>  { RecoverPassScreen(onGoLogin = { nav.popBackStack() }) }

        // ----- Home -----
        composable<HomeRoute> { HomeScreen(nav) }

        // ----- Product Detail -----
        composable<ProductDetailRoute> { entry ->
            ProductDetailScreen(entry)
        }
    }
}

private fun NavController.navigateToHomeClearingAuth() {
    navigate(HomeRoute) {
        popUpTo<LoginRoute> { inclusive = true }
    }
}
```

> 🧩 `@Serializable` permite definir rutas con parámetros de forma segura y tipada.

---

### 🔸 Archivo `Routes.kt`

```kotlin
@Serializable data object LoginRoute
@Serializable data object RegisterRoute
@Serializable data object RecoverRoute

@Serializable data object HomeRoute

@Serializable data class ProductDetailRoute(val id: String)
```

Gracias a esto podemos navegar usando:

```kotlin
nav.navigate(ProductDetailRoute(id = "123"))
```
Y recuperar el argumento en destino con:
```kotlin
val args = entry.toRoute<ProductDetailRoute>()
```

---

## 🧱 Navegación entre pantallas

### Desde `HomeScreen.kt`
```kotlin
ProductItem(
    product = product,
    onClick = { nav?.navigate(ProductDetailRoute(id = it.id)) }
)
```

### En `ProductDetailsScreen.kt`
```kotlin
@Composable
fun ProductDetailScreen(entry: NavBackStackEntry) {
    val args = entry.toRoute<ProductDetailRoute>()
    val id = args.id
    Text("Detalle del producto con ID: $id")
}
```

---

## 📦 Dependencias necesarias

En `build.gradle (module)`:

```gradle
implementation("androidx.navigation:navigation-compose:2.8.0")
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
implementation("androidx.compose.runtime:runtime:1.7.0")

plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}
```

---

## 🌐 Permisos de red

En el archivo `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

---

## 🧩 Cómo se gestionan los productos

### `Product.kt`
```kotlin
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String
)
```

### `ProductRepository.kt`
```kotlin
object ProductRepository {
    fun getAllProducts(): List<Product> = listOf(
        Product("1", "Auriculares RGB", 89.99, "..."),
        Product("2", "Teclado Mecánico", 129.99, "..."),
        Product("3", "Ratón Gamer", 59.99, "...")
    )
}
```

En `HomeScreen.kt`, mostramos la lista:
```kotlin
val products = ProductRepository.getAllProducts()
LazyColumn {
    items(products) { product ->
        ProductItem(product = product, onClick = { nav.navigate(ProductDetailRoute(product.id)) })
    }
}
```

Esto permite practicar **navegación con parámetros (`id`)** mientras se trabaja con listas.

---

## 🧭 Cómo funciona la navegación con parámetros

1. **Definimos una ruta con parámetros**
   ```kotlin
   @Serializable data class ProductDetailRoute(val id: String)
   ```

2. **Navegamos pasando el parámetro**
   ```kotlin
   nav.navigate(ProductDetailRoute(id = product.id))
   ```

3. **Recuperamos el valor en la pantalla destino**
   ```kotlin
   val args = entry.toRoute<ProductDetailRoute>()
   ```

> ✅ Todo tipado, sin usar strings ni `Bundle`s manuales.

---

## 💻 Clonar y ejecutar el proyecto

```bash
git clone https://github.com/tuusuario/nav3example.git
cd nav3example
./gradlew assembleDebug
```

Abre el proyecto con **Android Studio**, sincroniza gradle y ejecútalo en un emulador o dispositivo real.

---

## ✨ Ventajas del sistema de rutas tipadas

✅ Evitamos lo que son errores de rutas mal escritas.  
✅ Nos permite navegación con argumentos sin bundles ni strings.  
✅ Hacemos Código más limpio, mantenible y seguro.  
✅ Integración directa con Kotlin Serialization.  
✅ Perfecto para proyectos escalables y modernos en Compose.

---

Hecho con ❤️ para vosotros.
