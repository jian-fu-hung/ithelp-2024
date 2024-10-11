package com.jerryhong.ithelpsideproject.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.jerryhong.ithelpsideproject.core.AppDataManager
import com.jerryhong.ithelpsideproject.data.SubscriptionViewData
import com.jerryhong.ithelpsideproject.ui.base.BaseViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val appDataManager: AppDataManager) : BaseViewModel() {

    companion object {
        fun createFactory(appDataManager: AppDataManager) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return DetailViewModel(appDataManager) as T
            }
        }
    }

    val state: StateFlow<DetailState>
        get() = mState

    private var mState = MutableStateFlow<DetailState>(DetailState.Empty)


    fun getData(id: String? = null) {
        MainScope().launch {
            if (id.isNullOrEmpty()) {
                mState.value = DetailState.Create
            } else {
                val list = appDataManager.getData()
                val item = list.find { it.id == id }
                if (item == null) {
                    mState.value = DetailState.Error
                } else {
                    mState.value = DetailState.Edit(item)
                }
            }

        }
    }

    fun saveData(data: SubscriptionViewData) {
        if (data.id.isEmpty()) {
            MainScope().launch {
                appDataManager.setData(data)
            }
        } else {
            MainScope().launch {
                appDataManager.updateData(data)
            }
        }
    }
}