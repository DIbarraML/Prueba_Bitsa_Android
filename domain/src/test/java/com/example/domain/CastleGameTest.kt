package com.example.domain

import org.junit.Assert
import org.junit.Test

class CastleGameTest {

    private val castleGame = CastleGame()
    private val persons: List<Int> = List(NUM_PERSONS) { it + 1 }
    private val windows: List<Window> = List(NUM_WINDOWS) { Window(it + 1) }

    @Test
    fun `when list is not null and is not empty after changing states`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        // Given
        Assert.assertNotNull(persons)
        Assert.assertNotNull(windows)
        Assert.assertTrue(persons.isNotEmpty())
        Assert.assertTrue(windows.isNotEmpty())
    }

    @Test
    fun `when state is A and person 5 change to I`() {
        // When
        val numWindow = 5
        // Then
        castleGame.changeState(numWindow, windows)
        // Given
        Assert.assertEquals(StateWindow.I, windows[numWindow-1].stateWindow)
    }

    @Test
    fun `when state is A and person 7 change to I`() {
        // When
        val numWindow = 7
        // Then
        castleGame.changeState(numWindow, windows)
        // Given
        Assert.assertEquals(StateWindow.I, windows[numWindow-1].stateWindow)
    }

    @Test
    fun `when state is A and person 4 change to D`() {
        // When
        val numWindow = 4
        // Then
        castleGame.changeState(numWindow, windows)
        // Given
        Assert.assertEquals(StateWindow.D, windows[numWindow-1].stateWindow)
    }

    @Test
    fun `when state is C and person 1 change to I`() {
        // When
        val numWindow = 1
        // Then
        castleGame.changeState(numWindow, windows)
        // Given
        Assert.assertEquals(StateWindow.I, windows[numWindow-1].stateWindow)
    }

    @Test
    fun `when state is I and person 2 change to A`() {
        // When
        val numWindow = 2
        // Then
        castleGame.changeState(numWindow, windows)
        // Given
        Assert.assertEquals(StateWindow.A, windows[numWindow-1].stateWindow)
    }

    @Test
    fun `when there is no winner`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.searchWins(windows)
        // Given
        Assert.assertEquals(0, wins.size)
    }

    @Test
    fun `when the winner is number 3`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        windows[2].stateWindow = StateWindow.C
        windows[3].stateWindow = StateWindow.A
        windows[4].stateWindow = StateWindow.C
        val wins = castleGame.searchWins(windows)
        // Given
        Assert.assertEquals(1, wins.size)
    }

    @Test
    fun `when the state of 5 is I`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.getStateAllWindows(windows)
        // Then
        val result = "Ala Izquierda Abierta"
        // Given
        Assert.assertEquals(result, wins[4])
    }

    @Test
    fun `when the state of 3 is I`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.getStateAllWindows(windows)
        // Then
        val result = "Ala Izquierda Abierta"
        // Given
        Assert.assertEquals(result, wins[2])
    }

    @Test
    fun `when the state of 4 is D`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.getStateAllWindows(windows)
        // Then
        val result = "Ala Derecha Abierta"
        // Given
        Assert.assertEquals(result, wins[3])
    }

    @Test
    fun `when the state of 1 is C without starting actions`() {
        // When
        val wins = castleGame.getStateAllWindows(windows)
        // Then
        val result = "Abierto"
        // Given
        Assert.assertEquals(result, wins[0])
    }

    @Test
    fun `when the state of 2 is A`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.getStateAllWindows(windows)
        // Then
        val result = "Abierto"
        // Given
        Assert.assertEquals(result, wins[1])
    }

    @Test
    fun `when get more winners and winner is 2`() {
        // When
        castleGame.actionsWindowsWithPersons(persons, windows)
        val wins = castleGame.searchMoreWins(windows)
        // Then
        val result = 2
        // Given
        Assert.assertTrue(wins.size == 1)
        Assert.assertEquals(result, wins[0])
        Assert.assertEquals(result, wins[0])
    }

    companion object {
        private const val NUM_WINDOWS = 64
        private const val NUM_PERSONS = NUM_WINDOWS
    }
}