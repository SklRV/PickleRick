package dev.application.pickle_rick.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteCharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCharacter(favoriteCharacterEntity: FavoriteCharacterEntity)

    @Delete
    suspend fun deleteFavoriteCharacter(favoriteCharacterEntity: FavoriteCharacterEntity)

    @Query("SELECT EXISTS(SELECT * FROM FavoriteCharacterTable WHERE id  = :characterId)")
    suspend fun isFavoriteCharacterSaved(characterId: String): Boolean

    @Query("SELECT * FROM FavoriteCharacterTable")
    suspend fun getAllFavoriteCharacters(): List<FavoriteCharacterEntity>
}
