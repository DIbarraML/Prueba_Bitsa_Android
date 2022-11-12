package com.example.prueba_bitsa.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CastleViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CastleViewModel() as T
    }
}