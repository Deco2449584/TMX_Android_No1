package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
    fun searchNotes(query: String?): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE priority = :priority")
    fun getNotesByPriority(priority: Int): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE status = :status")
    fun getNotesByStatus(status: String): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE startDate >= :startDate AND endDate <= :endDate")
    fun getNotesByDateRange(startDate: Long, endDate: Long): LiveData<List<Note>>

   @Query("SELECT * FROM notes WHERE labels LIKE :label")
    fun getNotesByLabel(label: String): LiveData<List<Note>>

}
