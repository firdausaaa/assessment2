package assessment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import assessment2.database.GameDao
import assessment2.model.Game

class MainViewModel(dao: GameDao) : ViewModel() {

    val data : StateFlow<List<Game>> = dao.getGame().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}