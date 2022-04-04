package com.example.github_user_navigationapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.github_user_navigationapi.ui.setting.SettingPreferences
import kotlinx.coroutines.launch

class MainViewModel (private val pref: SettingPreferences) : ViewModel() {

    fun saveThemeSetting(isInDarkMode: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isInDarkMode)
        }
    }
    fun getThemeSettings(): LiveData<Boolean> = pref.getThemeSetting().asLiveData()


}