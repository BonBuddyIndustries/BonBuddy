package com.example.bonbuddy.repos.theme

import kotlinx.coroutines.flow.StateFlow

interface IThemeRepository
{
    val isDarkMode: StateFlow<Boolean>
    fun setDarkMode(isDarkMode: Boolean)
    fun toggleDarkMode()
}