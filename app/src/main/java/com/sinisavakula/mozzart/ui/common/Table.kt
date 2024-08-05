package com.sinisavakula.mozzart.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sinisavakula.mozzart.ui.results.ResultNumberItem
import com.sinisavakula.mozzart.ui.round.TalonNumberItem

@Composable
fun Table(
    numberOfRow: Int,
    numberOfColumn: Int,
    numbers: List<Int>,
    selectedNumbers: List<Int>? = null,
    onClickNumber: ((Boolean, Int) -> Unit)? = null,
    isTalon: Boolean
) {
    Column {
        repeat(numberOfRow) { row ->
            Row {
                repeat(numberOfColumn) { column ->
                    val number = row * numberOfColumn + column
                    if (number < numbers.size) {
                        if (isTalon) {
                            TalonNumberItem(
                                modifier = Modifier.weight(1F),
                                number = numbers[number],
                                isSelected = selectedNumbers?.contains(numbers[number]) == true,
                                onClick = { isSelected, selectedNumber ->
                                    onClickNumber?.invoke(isSelected, selectedNumber)
                                }
                            )
                        } else {
                            ResultNumberItem(
                                modifier = Modifier.weight(1F),
                                number = numbers[number],
                            )
                        }
                    }
                }
            }
        }
    }
}