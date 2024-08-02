package com.sinisavakula.mozzart.ui.round

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.repositories.TalonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlin.random.Random

abstract class RoundViewModel : ViewModel() {
    abstract val selectedNumbers: Flow<List<Int>>
    abstract val round: Flow<Round>
    abstract val event: Channel<RoundEvent>
    abstract fun setNumber(isChecked: Boolean, number: Int)
    abstract fun setRandomNumbers()
    abstract fun payment()
    abstract fun getDrawTime():Long
}

class RoundViewModelImpl(
    val drawId: Int,
    val talonRepository: TalonRepository
) : RoundViewModel() {

    override val selectedNumbers = MutableStateFlow(listOf<Int>())
    override val round = MutableStateFlow(Round())
    override val event = Channel<RoundEvent>()

    init {
        getRound()
    }
    private fun getRound(){
        viewModelScope.launch {
            try {
                round.emit(talonRepository.getRound(drawId))
                event.send(RoundEvent.RoundFetched)
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            }
        }
    }
    override fun setNumber(isChecked: Boolean, number: Int) {
        viewModelScope.launch {
            val list = arrayListOf<Int>()
            if (isChecked) {
                selectedNumbers.let { numbers ->
                    list.addAll(numbers.value)
                }
                if (list.size < 20) {
                    list.add(number)
                }
            } else {
                selectedNumbers.let { list.addAll(it.value) }
                list.remove(number)
            }

            selectedNumbers.emit(list)
        }
    }

    override fun setRandomNumbers() {
        val list = arrayListOf<Int>()
        list.addAll(selectedNumbers.value)
        while (list.size < 20) {
            val randomNum = Random.nextInt(1, 81)
            list.add(randomNum)
        }
        viewModelScope.launch {
            selectedNumbers.emit(list)
        }
    }

    override fun payment() {

    }

    override fun getDrawTime(): Long {
        return round.value.drawTime
    }
}

sealed class RoundEvent {
    data object RoundFetched : RoundEvent()
}

class RoundViewModelPreview : RoundViewModel() {
    override val selectedNumbers: Flow<List<Int>> = flowOf()
    override val round: Flow<Round> = flowOf()
    override val event = Channel<RoundEvent>()

    override fun setNumber(isChecked: Boolean, number: Int) {}
    override fun setRandomNumbers() {}
    override fun payment() {}
    override fun getDrawTime(): Long = 0
}