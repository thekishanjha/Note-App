package com.example.noteapp.View



import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.noteapp.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


class MainActivityTest{
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)



    @Test
      fun testAddButton(){

          onView(withId(R.id.item_add_note)).perform(click())
      }

    @Test
    fun testSaveButton(){
        onView(withId(R.id.editTextNoteTitle)).perform(typeText("title3"))
        onView(withId(R.id.editTextNoteDescription)).perform(typeText("Desc3"))

        onView(withId(R.id.buttonSave)).perform(click())
        onView(withId(R.id.textViewTitle)).check(matches(withText("title3")))
        onView(withId(R.id.textViewDescription)).check(matches(withText("Desc3")))

    }

}