package com.example.bonbuddy.viewmodel.theme

import androidx.lifecycle.ViewModel
import com.example.bonbuddy.repos.theme.IThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(private val themeRepository: IThemeRepository) :
    ViewModel()
{
    val isDarkMode = themeRepository.isDarkMode
    fun toggleDarkMode()
    {
        themeRepository.toggleDarkMode()
    }

    fun setDarkMode(isDarkMode: Boolean)
    {
        themeRepository.setDarkMode(isDarkMode)
    }
}