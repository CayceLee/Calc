package com.example.calc

sealed class CalcOperation(val symbol: String) {
    object Add: CalcOperation("+")
    object Sub: CalcOperation("-")
    object Mult: CalcOperation("*")
    object Divide: CalcOperation("/")

}