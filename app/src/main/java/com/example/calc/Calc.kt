package com.example.calc

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calc.ui.theme.PurpleGrey40

@Composable
fun Calc(
    state: DisplayState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 2.dp,
    onAction: (CalcEvents) -> Unit
) {
    Box (modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.num1 + (state.operation?.symbol ?: "") + state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth(),
                fontWeight = FontWeight.Light,
                fontSize = 54.sp,
                color = Color.Black,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcBtn(
                    title = "C",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalcEvents.Clear)
                    }
                )
                CalcBtn(
                    title = "Del",
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Delete)
                    }
                )
                CalcBtn(
                    title = "/",
                    modifier = Modifier
                        .background(color = PurpleGrey40)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Operation(CalcOperation.Divide))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcBtn(
                    title = "7",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(7))
                    }
                )
                CalcBtn(
                    title = "8",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(8))
                    }
                )
                CalcBtn(
                    title = "9",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(9))
                    }
                )
                CalcBtn(
                    title = "*",
                    modifier = Modifier
                        .background(color = PurpleGrey40)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Operation(CalcOperation.Mult))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcBtn(
                    title = "4",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(4))
                    }
                )
                CalcBtn(
                    title = "5",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(5))
                    }
                )
                CalcBtn(
                    title = "6",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(6))
                    }
                )
                CalcBtn(
                    title = "-",
                    modifier = Modifier
                        .background(color = PurpleGrey40)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Operation(CalcOperation.Sub))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcBtn(
                    title = "1",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(1))
                    }
                )
                CalcBtn(
                    title = "2",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(2))
                    }
                )
                CalcBtn(
                    title = "3",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Num(3))
                    }
                )
                CalcBtn(
                    title = "+",
                    modifier = Modifier
                        .background(color = PurpleGrey40)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Operation(CalcOperation.Add))
                        Log.d("+ button", "Addition was hit")
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcBtn(
                    title = "0",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalcEvents.Num(0))
                }
                CalcBtn(
                    title = ".",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcEvents.Deci)
                    }
                )
                CalcBtn(
                    title = "=",
                    modifier = Modifier
                        .background(color = PurpleGrey40)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalcEvents.Calculate)
                }
            }
        }
    }
}