package com.example.currencyconvertor.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconvertor.domain.FetchUseCase
import com.example.currencyconvertor.domain.model.ErrorType
import com.example.currencyconvertor.domain.model.MyResult
import com.example.currencyconvertor.ui.model.DataUi
import com.example.currencyconvertor.ui.model.MapDomainToUi
import com.example.currencyconvertor.utils.ToDispatch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val fetchUseCase: FetchUseCase,
    private val mapper: MapDomainToUi,
    private val dispatchers: ToDispatch
) : ViewModel() {

    private var mDataOne = MutableLiveData<DataUi>()
    private var mDataTwo = MutableLiveData<DataUi>()
    private var mError = MutableLiveData<ErrorType>()
    private var mLoading = MutableLiveData(false)
    private var mDataCheckedOne = MutableLiveData<List<DataUi.Rate>>()
    private var mDataCheckedTwo = MutableLiveData<List<DataUi.Rate>>()
    private var mCurrency1 = MutableLiveData<DataUi.Rate>()
    private var mCurrency2 = MutableLiveData<DataUi.Rate>()

    val dataOne: LiveData<DataUi>
        get() = mDataOne
    val dataTwo: LiveData<DataUi>
        get() = mDataTwo
    val dataCheckedOne: LiveData<List<DataUi.Rate>>
        get() = mDataCheckedOne
    val dataCheckedTwo: LiveData<List<DataUi.Rate>>
        get() = mDataCheckedTwo
    val error: LiveData<ErrorType>
        get() = mError
    val loading: LiveData<Boolean>
        get() = mLoading
    val currency1: LiveData<DataUi.Rate>
        get() = mCurrency1
    val currency2: LiveData<DataUi.Rate>
        get() = mCurrency2

    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }
    private val scope = CoroutineScope(Job() + exceptionHandler)

    private fun fetch() {
        mLoading.value = true
        dispatchers.launchUI(scope = scope) {
            delay(3000)
            this.coroutineContext
            when (val result = fetchUseCase.fetchCloud()) {
                is MyResult.Success -> {
                    mLoading.value = false
                    mDataOne.value = mapper.transform(result.data)
                    mDataTwo.value = mapper.transform(result.data)
                }
                is MyResult.Fail -> {
                    mLoading.value = false
                    mError.value = result.errorType
                }
            }
        }
    }

    init {
        fetch()
    }

    fun setCheckedCurrencyOne(name: String) {
        val listOfChecked = mutableListOf<DataUi.Rate>()
        val list = mDataOne.value?.rate

        list?.forEach {
            if (it.name != name) {
                it.isChecked = false
            } else {
                mCurrency1.value = it
            }
            listOfChecked.add(it)
        }
        mDataCheckedOne.value = listOfChecked
    }

    fun setCheckedCurrencyTwo(name: String) {
        val listOfChecked = mutableListOf<DataUi.Rate>()
        val list = mDataTwo.value?.rate

        list?.forEach {
            if (it.name != name) {
                it.isChecked = false
            } else {
                mCurrency2.value = it
            }
            listOfChecked.add(it)
        }
        mDataCheckedTwo.value = listOfChecked
    }
}