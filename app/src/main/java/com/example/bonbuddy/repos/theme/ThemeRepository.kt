package com.example.bonbuddy.repos.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeRepository : IThemeRepository
{
    private val _darkMode = MutableStateFlow(false)
    override val isDarkMode: StateFlow<Boolean> = _darkMode

    override fun setDarkMode(isDarkMode: Boolean)
    {
        _darkMode.value = isDarkMode
    }

    override fun toggleDarkMode()
    {
        setDarkMode(!_darkMode.value)
    }
}