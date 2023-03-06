package com.example.currencyconvertor.ui.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.currencyconvertor.R
import com.example.currencyconvertor.databinding.FragmentMainBinding
import com.example.currencyconvertor.ui.BaseFragment
import com.example.currencyconvertor.ui.model.DataUi
import com.example.currencyconvertor.utils.snackLong
import com.example.currencyconvertor.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(), TextWatcher {

    private val vm by activityViewModels<MainFragmentViewModel>()
    private var mWatcher = 1
    private var mCount = 0.0

    private lateinit var currencyOne: DataUi.Rate
    private lateinit var currencyTwo: DataUi.Rate

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextCurrencyOne.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.editTextCurrencyOne.addTextChangedListener(this)
                binding.editTextCurrencyTwo.removeTextChangedListener(this)
                mWatcher = 1
                binding.editTextCurrencyOne.setText("")
            }
        }

        binding.editTextCurrencyTwo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.editTextCurrencyTwo.addTextChangedListener(this)
                binding.editTextCurrencyOne.removeTextChangedListener(this)
                mWatcher = 2
                binding.editTextCurrencyTwo.setText("")
            }
        }

        vm.dataOne.observe(viewLifecycleOwner) {
            binding.mainGroup.visible(true)
            currencyOne = it.rate[0]
            currencyTwo = it.rate[1]
            binding.currencyOne.text = currencyOne.name
            binding.abbreviationOne.text = currencyOne.abbreviation
            binding.currencyTwo.text = currencyTwo.name
            binding.abbreviationTwo.text = currencyTwo.abbreviation
        }

        vm.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) binding.progressBar.visible(true)
            else binding.progressBar.visible(false)
        }

        vm.error.observe(viewLifecycleOwner) { errorType ->
            when (errorType.ordinal) {
                0 -> view.snackLong(R.string.no_connection_exception_message)
                1 -> view.snackLong(R.string.http_exception_message)
                2 -> view.snackLong(R.string.generic_exception_message)
            }
        }

        vm.currency1.observe(viewLifecycleOwner) {
            currencyOne = it
            binding.currencyOne.text = it.name
            binding.abbreviationOne.text = it.abbreviation
            mCount = it.rate
        }

        vm.currency2.observe(viewLifecycleOwner) {
            currencyTwo = it
            binding.currencyTwo.text = it.name
            binding.abbreviationTwo.text = it.abbreviation
        }

        binding.changeCurrencyOne.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_currencyOneSelectFragment)
        }

        binding.changeCurrencyTwo.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_currencyTwoSelectFragment)
        }
    }

    override fun onPause() {
        super.onPause()
        binding.editTextCurrencyTwo.setText("")
        binding.editTextCurrencyOne.setText("")
    }

    override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (charSequence.isNullOrBlank()) return
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (p0.isNullOrBlank()) {
            when (mWatcher) {
                1 -> binding.editTextCurrencyTwo.setText("")
                2 -> binding.editTextCurrencyOne.setText("")
            }
        }
    }

    override fun afterTextChanged(textChanged: Editable?) {
        if (textChanged.isNullOrBlank()) return

        mCount = textChanged.toString().toDouble()

        when (mWatcher) {
            1 -> {
                if (currencyOne.abbreviation == "RUB" || currencyTwo.abbreviation == "RUB") {
                    val result = (mCount * currencyTwo.rate).toString()
                    binding.editTextCurrencyTwo.setText(result)
                } else {
                    val result = (mCount * (currencyTwo.rate / currencyOne.rate)).toString()
                    binding.editTextCurrencyTwo.setText(result)
                }
            }
            2 -> {
                if (currencyOne.abbreviation == "RUB" || currencyTwo.abbreviation == "RUB") {
                    val result = (mCount / currencyTwo.rate).toString()
                    binding.editTextCurrencyOne.setText(result)
                } else {
                    val result = ((mCount / currencyTwo.rate) * currencyOne.rate).toString()
                    binding.editTextCurrencyOne.setText(result)
                }
            }
        }
    }
}