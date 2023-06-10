package com.example.calc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {

    var state by mutableStateOf(DisplayState())
        private set

    fun onAction(action: CalcEvents) {
        when(action) {
            is CalcEvents.Num -> enterNumber(action.number)
            is CalcEvents.Deci -> enterDecimal()
            is CalcEvents.Operation -> enterOperation(action.operation)
            is CalcEvents.Clear -> state = DisplayState()
            is CalcEvents.Delete -> performDelete()
            is CalcEvents.Calculate -> performCalculation()

        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.num1.length >= 9) {
                return
            }
            else if (state.num1 == "0"){
                state = state.copy(
                    num1 =  number.toString()
                )
            }
            else {
                state = state.copy(
                    num1 = state.num1 + number
                )
                return
            }
        } else if (state.operation != null) {
            if(state.num2.length >= 9) {
                return
            }
            else {
                state = state.copy(
                    num2 = state.num2 + number
                )
                return
            }
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && state.num1.isBlank()) {
            state = state.copy(
                num1 = "0."
            )
            return
        }
        if(state.operation == null && !state.num1.contains(".")){
            state = state.copy(
                num1 = state.num1 + "."
            )
            return
        }
        if(state.operation != null && state.num2.isBlank()) {
            state = state.copy(
                num2 = "0."
            )
            return
        }
        if(state.operation != null && !state.num2.contains(".")) {
            state = state.copy(
                num2 = state.num2 + "."
            )
            return
        }
    }

    private fun enterOperation(operation: CalcOperation) {
        if(state.num1.isNotBlank()) {
            state = state.copy(operation = operation)
        }    }

    private fun performDelete() {
        when {
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )
            state.num2.isBlank() && state.operation != null -> state = state.copy(
                operation = null
            )
            state.num1.isNotBlank() && state.operation == null -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {

        if (state.num1.contains(".") || state.num2.contains(".")) {
            val num1 = state.num1.toDoubleOrNull()
            val num2 = state.num2.toDoubleOrNull()
            if(num1 != null && num2 != null){

                val result = when(state.operation) {
                    is CalcOperation.Add -> num1 + num2
                    is CalcOperation.Sub -> num1 - num2
                    is CalcOperation.Mult -> num1 * num2
                    is CalcOperation.Divide -> num1 / num2
                    null -> return
                }
                state = state.copy(
                    num1 = result.toString().take(15),
                    num2 = "",
                    operation = null
                )
            }
        }
        else {
            val num1 = state.num1.toIntOrNull()
            val num2 = state.num2.toIntOrNull()
            if(num1 != null && num2 != null){

                val result = when(state.operation) {
                    is CalcOperation.Add -> num1 + num2
                    is CalcOperation.Sub -> num1 - num2
                    is CalcOperation.Mult -> num1 * num2
                    is CalcOperation.Divide -> num1 / num2
                    null -> return
                }
                state = state.copy(
                    num1 = result.toString().take(15),
                    num2 = "",
                    operation = null
                )
            }
        }

    }
}