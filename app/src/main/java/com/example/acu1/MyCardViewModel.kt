package com.example.acu1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

enum class QrType {
    GITHUB,
    LINKEDIN,
    NONE
}

class MyCardViewModel : ViewModel() {
    private val _alertLangIsVisible = mutableStateOf(false)
    val alertLangIsVisible: State<Boolean> get() = _alertLangIsVisible
    private val _bottomSheetType = mutableStateOf(QrType.NONE)
    val bottomSheetType: State<QrType> get() = _bottomSheetType
    private val _startActivityEvent = MutableSharedFlow<Lang>()
    val startActivityEvent = _startActivityEvent.asSharedFlow()

    fun hideAlert() {
        assert(_alertLangIsVisible.value)
        _alertLangIsVisible.value = false
    }

    fun showAlert() {
        assert(!_alertLangIsVisible.value)
        _alertLangIsVisible.value = true
    }

    fun showBottomSheet(type: QrType) {
        assert(type != QrType.NONE)
        _bottomSheetType.value = type
    }

    fun hideBottomSheet() {
        assert(_bottomSheetType.value != QrType.NONE)
        _bottomSheetType.value = QrType.NONE
    }

    fun triggerStartActivity(lang: Lang) {
        viewModelScope.launch {
            _startActivityEvent.emit(lang)
        }
    }
}
