package assessment2.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Game")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val catatan: String,
    val kategori:String

)