package com.sinisavakula.mozzart.misc

import com.sinisavakula.mozzart.R

fun Int.toBorderColor(): Int {
    return when (this){
        in 1..10 -> R.color.yellow_number
        in 11..20 -> R.color.orange_number
        in 21..30 -> R.color.red_number
        in 31..40 -> R.color.pink_number
        in 41..50 -> R.color.purple_number
        in 51..60 -> R.color.light_blue_number
        in 61..70 -> R.color.green_number
        in 71..80 -> R.color.blue_number
        else -> R.color.yellow_number
    }
}