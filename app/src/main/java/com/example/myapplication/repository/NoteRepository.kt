package com.example.myapplication.repository

import androidx.room.Query
import com.example.myapplication.database.NoteDatabase
import com.example.myapplication.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun  insertNote(note: Note) = db.getNOteDao().insertNote(note)
    suspend fun  deleteNote(note: Note) = db.getNOteDao().deleteNote(note)
    suspend fun  updateNote(note: Note) = db.getNOteDao().updateNote(note)

    fun getAllNotes() = db.getNOteDao().getALLNotes()
    fun searchNotes(query: String) = db.getNOteDao().searchNote(query)
}
