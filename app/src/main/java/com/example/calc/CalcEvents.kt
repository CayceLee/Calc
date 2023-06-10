package com.example.calc

sealed class CalcEvents {
    data class Num(val number: Int): CalcEvents()
    object Clear: CalcEvents()
    object Delete: CalcEvents()
    object Deci: CalcEvents()
    object Calculate: CalcEvents()
    data class Operation(val operation: CalcOperation): CalcEvents()
}
