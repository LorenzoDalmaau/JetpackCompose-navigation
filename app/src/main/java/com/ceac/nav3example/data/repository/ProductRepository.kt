package com.ceac.nav3example.data.repository

import com.ceac.nav3example.data.model.Product

object ProductRepository {
    private val items = listOf(
        Product(
            id = "p1",
            title = "Teclado Mecánico RGB",
            price = 129.99,
            image = "https://picsum.photos/seed/keyboard/600/400",
            description = "Switches lineales, keycaps PBT, 75% layout."
        ),
        Product(
            id = "p2",
            title = "Ratón Inalámbrico Pro",
            price = 89.90,
            image = "https://picsum.photos/seed/mouse/600/400",
            description = "Sensor 26k DPI, 70h batería, 58g."
        ),
        Product(
            id = "p3",
            title = "Auriculares Hi-Fi",
            price = 159.00,
            image = "https://picsum.photos/seed/headset/600/400",
            description = "Drivers de 50mm, latencia ultra baja."
        )
    )

    fun getAll(): List<Product> = items
    fun getById(id: String): Product? = items.find { it.id == id }
}
