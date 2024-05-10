package org.d3if3004.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3004.mobpro1.database.GameDao
import org.d3if3004.mobpro1.model.Game

class MainViewModel(dao: GameDao) : ViewModel() {

    val data : StateFlow<List<Game>> = dao.getGame().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}