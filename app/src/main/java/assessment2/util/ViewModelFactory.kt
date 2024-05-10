package org.d3if3004.mobpro1.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import assessment2.database.GameDao
import assessment2.ui.screen.DetailViewModel
import assessment2.ui.screen.MainViewModel


class ViewModelFactory(private val dao: GameDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}