package com.example.noteapp

import android.app.Application
import com.example.noteapp.Repository.NoteRepository
import com.example.noteapp.Room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope

class NoteApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }

}