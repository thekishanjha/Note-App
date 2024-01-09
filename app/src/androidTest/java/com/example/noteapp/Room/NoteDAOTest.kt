package com.example.noteapp.Room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.noteapp.Model.Note
import com.example.noteapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class NoteDAOTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NoteDatabase
    private lateinit var dao: NoteDAO

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.getNoteDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insert() = runBlocking {
        val note = Note("TitleTest","DescriptionTest")
        dao.insert(note)

        val allNotes = dao.getAllNotes().asLiveData().getOrAwaitValue()
        assertThat(allNotes).contains(note)
    }
}