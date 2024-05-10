package assessment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import assessment2.database.GameDao
import assessment2.model.Game

class DetailViewModel (private val dao: GameDao): ViewModel() {

    fun insert(nama:String, catatan:String, kategori: String){
        val Game = Game (
            nama = nama,
            catatan = catatan,
            kategori = kategori
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(Game)
        }
    }

    suspend fun getGame(id:Long): Game?{
        return dao.getGameById(id)
    }

    fun  update(id: Long, nama: String,catatan: String,kategori: String){
        val Game = Game(
            id = id,
            nama = nama,
            catatan = catatan,
            kategori = kategori
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(Game)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }

}
