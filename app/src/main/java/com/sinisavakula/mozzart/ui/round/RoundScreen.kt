package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.misc.toRemainingTime
import com.sinisavakula.mozzart.misc.toSecond
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
    var isTimeIsUp by remember { mutableStateOf(false) }
    val round = viewModel.round
    var remainingTime by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            isTimeIsUp = (viewModel.getDrawTime()?.toSecond() ?: 0) < 1
            remainingTime = viewModel.getDrawTime()?.toRemainingTime().toString()
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
    if (isTimeIsUp) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            AppDialog(
                title = R.string.time_is_up,
                onClickButton = {
                    isTimeIsUp = false
                    navigateBack()
                })
        }
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