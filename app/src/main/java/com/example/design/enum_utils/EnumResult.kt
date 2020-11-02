package com.example.design.enum_utils

import com.example.design.R

enum class EnumResult (
    val parentDrawble : Int,
    val drawbleDivider: Int,
    val textTitle : Int,
    val smallTitle: Int,
    val color : Int,
    val fullText : Int,
    val fullTextColor : Int
) {

    GREEN(
        R.drawable.green2_bcg,
        R.drawable.bg_green_button,
        R.string.title_green,
        R.string.smallText_lightgreen,
        R.color.green_btn,
        R.string.fullText_lightgreen,
        R.string.ligthgreen_fulltext
    ),

    LIGHTGREEN(
        R.drawable.green_bcg,
        R.drawable.bg_light_button,
        R.string.title_green,
        R.string.smallText_green,
        R.color.light_btn,
        R.string.fullText_green,
        R.string.fullText_colorGreen
    ),

    YELLOW(
        R.drawable.yellow_bcg,
        R.drawable.bg_yellow_button,
        R.string.title_yellow,
        R.string.smallText_yellow,
        R.color.yellow,
        R.string.fullText_yellow,
        R.string.fullText_colorYellow
    ),
    ORANGE(
        R.drawable.orange_bcg,
        R.drawable.bg_orange_button,
        R.string.title_orange,
        R.string.smallText_orange,
        R.color.orange_btn,
        R.string.fullText_orange,
        R.string.fullText_colorOrange
    ),
    RED(
        R.drawable.red_bcg,
        R.drawable.bg_red_button,
        R.string.title_red,
        R.string.smallText_red,
        R.color.red_btn,
        R.string.fullText_red,
        R.string.fullText_colorRed
    );

    companion object {
        fun selectTypeOfEnum(points: Int ): EnumResult {
            return when {
                points == 20 -> LIGHTGREEN
                points in 21..39 -> YELLOW
                points == 0 ->  GREEN
                points in 40..59 -> ORANGE
                else -> RED
            }

        }
    }
}