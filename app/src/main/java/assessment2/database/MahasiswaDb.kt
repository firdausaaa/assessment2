package org.d3if3004.mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3004.mobpro1.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameDb:RoomDatabase() {

    abstract val dao:GameDao

    companion object{
        @Volatile
        private var INSTANCE: GameDb? = null

        fun getInstance(context: Context):GameDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GameDb::class.java,
                        "Game.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}
