package com.sinisavakula.mozzart.model

enum class Odds(
    val number: Int, val odds: Double
) {
    ONE(1, 3.75),
    TWO(2, 14.0),
    THREE(3, 65.0),
    FOUR(4, 275.0),
    FIVE(5, 1350.0),
    SIX(6, 6500.0),
    SEVEN(7, 25000.0),
    EIGHT(8, 100000.0),
    NINE(9, 400000.0),
    TEN(10, 1600000.0),
    ELEVEN(11, 6400000.0),
    TWELVE(12, 20000000.0),
    THIRTEEN(13, 80000000.0),
    FOURTEEN(14, 300000000.0),
    FIFTEEN(15, 1000000000.0),
    SIXTEEN(16, 4000000000.0),
    SEVENTEEN(17, 12000000000.0),
    EIGHTEEN(18, 30000000000.0),
    NINETEEN(19, 100000000000.0),
    TWENTY(20, 300000000000.0);
}