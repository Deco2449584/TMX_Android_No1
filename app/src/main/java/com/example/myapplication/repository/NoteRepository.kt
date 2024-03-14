package com.example.myapplication.repository

import com.example.myapplication.database.NoteDatabase
import com.example.myapplication.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNotes(query: String?) = db.getNoteDao().searchNotes(query)

    fun getNotesByPriority(priority: Int) = db.getNoteDao().getNotesByPriority(priority)
    fun getNotesByStatus(status: String) = db.getNoteDao().getNotesByStatus(status)
    fun getNotesByDateRange(startDate: Long, endDate: Long) = db.getNoteDao().getNotesByDateRange(startDate, endDate)
    fun getNotesByLabel(label: String) = db.getNoteDao().getNotesByLabel(label)
}
