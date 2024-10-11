package com.jerryhong.ithelpsideproject.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.jerryhong.ithelpsideproject.core.AppDataManager
import com.jerryhong.ithelpsideproject.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val appDataManager: AppDataManager) : BaseViewModel() {

    companion object {
        fun createFactory(appDataManager: AppDataManager) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return HomeViewModel(appDataManager) as T
            }
        }
    }

    val state: StateFlow<HomeState>
        get() = mState

    private var mState = MutableStateFlow<HomeState>(HomeState.Empty)

    init {
        MainScope().launch(
            CoroutineExceptionHandler { coroutineContext, throwable ->
                mState.value = HomeState.Error(throwable.message ?: "")
            }
        ) {
            getData()
        }
    }

    fun reload() {
        MainScope().launch(CoroutineExceptionHandler { coroutineContext, throwable ->
            mState.value = HomeState.Error(throwable.message ?: "")
        }) {
            getData()
        }
    }

    private suspend fun getData() {
        Log.d("TAG", "getData: ")
        mState.value = HomeState.Loading
        delay(1 * 1000)
        val list = withContext(Dispatchers.IO) { appDataManager.getData() }
        mState.value = HomeState.Finish(list)
    }
}