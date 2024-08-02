package com.sinisavakula.mozzart.ui.round

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.sinisavakula.mozzart.misc.toRemainingTime
import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.ui.common.AppDialog
import com.sinisavakula.mozzart.ui.common.Toolbar
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme
import kotlinx.coroutines.delay

@Composable
fun RoundScreen(
    viewModel: RoundViewModel,
    navigateBack: () -> Unit
) {
    var isSuccessDialogShown by remember { mutableStateOf(false) }
    val round = viewModel.round.collectAsState(initial = Round()).value
    var remainingTime by remember { mutableStateOf("") }
    Log.d("TestTimeRemainig", "time: " + remainingTime)

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            remainingTime = viewModel.getDrawTime().toRemainingTime()
        }
    }
    Column {
        Toolbar(navigateBack = navigateBack)
        Talon(
            round = round,
            remainingTime = remainingTime,
            selectedNumbers = viewModel.selectedNumbers.collectAsState(initial = listOf()).value,
            onClickNumber = viewModel::setNumber,
            onClickRandom = viewModel::setRandomNumbers,
            onClickPayment = { isSuccessDialogShown = true }
        )
    }
    if (isSuccessDialogShown) {
        AppDialog(
            onClickButton = {
                isSuccessDialogShown = false
                navigateBack()
            })
    }
}

@Preview
@Composable
fun RoundScreenPreview() {
    MozzartSinisaVakulaTheme {
        RoundScreen(
            viewModel = RoundViewModelPreview(),
            navigateBack = {})
    }
}