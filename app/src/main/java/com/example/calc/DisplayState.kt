package com.example.calc

data class DisplayState(
    val num1: String = "0",
    val num2: String = "",
    val operation: CalcOperation? = null
)