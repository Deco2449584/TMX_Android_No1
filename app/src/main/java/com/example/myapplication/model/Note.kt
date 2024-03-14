package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String,
    val noteDesc: String,
    val priority: String,
    val status: String,
    val startDate: String,
    val endDate: String,
    val labels: String
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    companion object : Parceler<Note> {
        override fun Note.write(dest: Parcel, flags: Int) {
            TODO("Not yet implemented")
        }

        override fun create(parcel: Parcel): Note = TODO()
    }
}
