package com.photolab.vintage.util.bean

data class FilterConfig(
    var type: Int = FILTER,
    var assetUrl: String = "",
    var config: String = "",
    var name: String = "",
    var color: Int = 0,
    var isLastItem: Boolean = false,
    var intensive: Int = 100,
    var isPremium: Boolean = false
) {
    companion object {
        const val FILTER = 0
        const val LIGHT = 1
        const val DUST = 2
        const val GRADIENT = 3
        const val MASK = 4
        const val ADJUST = 5
    }

    constructor(
        type: Int,
        assetUrl: String,
        config: String,
        name: String,
        color: Int,
        intensive: Int
    ) : this(type, assetUrl, config, name, color, false, intensive, false)

    constructor(
        type: Int,
        assetUrl: String,
        config: String,
        name: String,
        color: Int,
        intensive: Int,
        isPremium: Boolean
    ) : this(type, assetUrl, config, name, color, false, intensive, isPremium)

    constructor(
        type: Int,
        assetUrl: String,
        config: String,
        name: String,
        color: Int,
        isLastItem: Boolean,
        intensive: Int
    ) : this(type, assetUrl, config, name, color, isLastItem, intensive, false)
}
