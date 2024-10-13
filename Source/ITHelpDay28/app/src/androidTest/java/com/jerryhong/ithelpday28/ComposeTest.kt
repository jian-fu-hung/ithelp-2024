package com.jerryhong.ithelpday28

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun greetingTest_addNumber() {
        composeTestRule.setContent {
            Greeting()
        }

        composeTestRule.onNodeWithText("Add").performClick()


        composeTestRule.onNodeWithText("1").assertIsDisplayed()
    }
}