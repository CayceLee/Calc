package my.calc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import my.calc.ui.theme.CalcTheme
import my.calc.models.Calc
import my.calc.viewmodel.CalcViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcTheme {
                val viewModel = viewModel<CalcViewModel>()
                val state = viewModel.state
                val spacing = 5.dp
                Calc(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = spacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.LightGray)
                        .padding(12.dp)
                )

            }
        }
    }
}