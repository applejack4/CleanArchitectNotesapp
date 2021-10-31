package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

//Dagger-Hilt Setup.
data class NoteUseCases(
    val getNotes : GetNotesUseCase,
    val deleteNotes : DeleteNotesUseCase,
    val addNotes : AddNote)