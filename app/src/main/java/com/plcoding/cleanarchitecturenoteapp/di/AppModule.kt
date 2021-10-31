package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImplementation
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.AddNote
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app : Application) : NoteDatabase {
        return Room.databaseBuilder(app ,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun providesRepository(db : NoteDatabase) : NoteRepository{
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: NoteRepository) : NoteUseCases{
        return NoteUseCases(
            deleteNotes = DeleteNotesUseCase(repository),
            getNotes = GetNotesUseCase(repository),
            addNotes = AddNote(repository)
        )
    }
}