package com.photolab.vintage.util.bean

data class CreditPackageConfig(
    val id: String,
    val title: String,
    val credits: Int,
    var price: String,
    val isBestValue: Boolean,
    val iconType: String
)
