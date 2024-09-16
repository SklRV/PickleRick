package dev.application.pickle_rick.di

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.application.pickle_rick.R
import dev.application.pickle_rick.data.local.db.AppDatabase
import dev.application.pickle_rick.data.local.db.FavoriteCharacterDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            ContextCompat.getString(appContext, R.string.db_name)
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(appDatabase: AppDatabase): FavoriteCharacterDao {
        return appDatabase.dao
    }
}
