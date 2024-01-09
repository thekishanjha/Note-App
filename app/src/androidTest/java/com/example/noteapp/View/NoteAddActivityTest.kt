package com.example.noteapp.View

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.CloseKeyboardAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.noteapp.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class NoteAddActivityTest{
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(NoteAddActivity::class.java)
    @Test
    fun testSaveButton(){

        Espresso.onView(ViewMatchers.withId(R.id.editTextNoteTitle))
            .perform(ViewActions.typeText("title3"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextNoteDescription))
            .perform(ViewActions.typeText("Desc3"))

        Espresso.onView(ViewMatchers.withId(R.id.buttonSave)).perform(ViewActions.click())



    }

    @Test
    fun testCancelButton(){

        Espresso.onView(ViewMatchers.withId(R.id.editTextNoteTitle))
            .perform(ViewActions.typeText("title3"))
        Espresso.onView(ViewMatchers.withId(R.id.editTextNoteDescription))
            .perform(ViewActions.typeText("Desc3"))

        Espresso.onView(ViewMatchers.withId(R.id.buttonCancel)).perform(ViewActions.click())



    }
}