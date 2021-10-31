package com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImplementation(private val dao : NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun insert(note : Note) {
        dao.insertNote(note)
    }

    override suspend fun delete(note: Note) {
        return dao.deleteNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
       return dao.getNoteById(id)
    }

}