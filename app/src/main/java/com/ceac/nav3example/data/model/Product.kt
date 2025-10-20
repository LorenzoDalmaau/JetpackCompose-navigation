package com.ceac.nav3example.data.model

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val image: String,      // aquí podríais usar painterResource si poneiss drawables
    val description: String
)