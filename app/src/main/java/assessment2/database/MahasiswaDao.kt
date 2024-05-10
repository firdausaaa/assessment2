package org.d3if3004.mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3004.mobpro1.model.Game

@Dao
interface GameDao {
    @Insert
    suspend fun insert(Game: Game)

    @Update
    suspend fun update(Game: Game)

//    @Query("SELECT * FROM Game ORDER By kelas,nim ASC")
    @Query("SELECT * FROM Game")
    fun getGame(): Flow<List<Game>>

    @Query("SELECT * FROM Game WHERE id = :id")
    suspend fun getGameById(id: Long):Game?

    @Query("DELETE FROM Game WHERE id = :id")
    suspend fun deleteById(id:Long)




}
