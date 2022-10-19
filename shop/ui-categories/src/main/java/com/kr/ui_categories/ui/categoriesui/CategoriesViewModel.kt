package com.kr.ui_categories.ui.categoriesui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kr.categories_interactors.usecase.CategoriesUseCase
import com.kr.core.Resource
import com.kr.ui_categories.ui.categoriesui.component.CategorisState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase
    )
    : ViewModel() {
    private val _state = mutableStateOf(CategorisState())
    val state: State<CategorisState> = _state
    init {
        categorieslist()
    }

    private fun categorieslist() {
       categoriesUseCase().onEach { result ->
            when (result) {

                is Resource.Success -> {
                    _state.value = CategorisState( Categorieslist = result.data!!.map { it })
                       Log.v("categories Response" , _state.value.toString())
                }
                is Resource.Error -> {
                    _state.value = CategorisState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CategorisState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}