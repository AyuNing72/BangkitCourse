package com.example.github_user_navigationapi.ui.setting

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.github_user_navigationapi.databinding.ActivitySettingsBinding
import com.example.github_user_navigationapi.ui.main.MainViewModel


class SettingsActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var settingsViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.title = "Pengaturan"

        val pref = SettingPreferences.getInstance(dataStore)
        settingsViewModel = ViewModelProvider(this, ViewModelFactory(pref))[MainViewModel::class.java]

        settingsViewModel.getThemeSettings().observe(this) { isInDarkMode: Boolean ->
            if (isInDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switchThemeSetting.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switchThemeSetting.isChecked = false
            }
        }

        binding.switchThemeSetting.setOnCheckedChangeListener { _, isChecked: Boolean ->
            settingsViewModel.saveThemeSetting(isChecked)
        }
    }
}