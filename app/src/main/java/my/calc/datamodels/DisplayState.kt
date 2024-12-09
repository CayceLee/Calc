package my.calc.datamodels

import my.calc.datamodels.CalcOperation

data class DisplayState(
    val num1: String = "0",
    val num2: String = "",
    val operation: CalcOperation? = null
)