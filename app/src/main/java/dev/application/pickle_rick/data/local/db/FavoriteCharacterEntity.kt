package dev.application.pickle_rick.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteCharacterTable")
data class FavoriteCharacterEntity(
    @PrimaryKey
    val id: String = "0"
)
