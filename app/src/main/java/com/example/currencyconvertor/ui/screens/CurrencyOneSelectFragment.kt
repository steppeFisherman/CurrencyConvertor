package com.example.currencyconvertor.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.currencyconvertor.R
import com.example.currencyconvertor.databinding.FragmentCurrencyOneSelectBinding
import com.example.currencyconvertor.ui.BaseFragment
import com.example.currencyconvertor.ui.adapters.CurrencyOneSelectAdapter
import com.example.currencyconvertor.ui.adapters.ListenerOne
import com.example.currencyconvertor.ui.model.DataUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyOneSelectFragment : BaseFragment<FragmentCurrencyOneSelectBinding>() {

    private val vm by activityViewModels<MainFragmentViewModel>()
    private lateinit var mAdapterOne: CurrencyOneSelectAdapter

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentCurrencyOneSelectBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapterOne = CurrencyOneSelectAdapter(object : ListenerOne {
            override fun invoke(dataUi: DataUi.Rate) {
                vm.setCheckedCurrencyOne(dataUi.name)
                mAdapterOne.notifyDataSetChanged()
            }
        })

        binding.rvFragmentCurrencySelect.adapter = mAdapterOne

        vm.dataOne.observe(viewLifecycleOwner) {
            mAdapterOne.submitList(it.rate)
        }

        vm.dataCheckedOne.observe(viewLifecycleOwner) {
            mAdapterOne.submitList(it)
        }

        binding.txtCancel.setOnClickListener {
            findNavController().navigate(R.id.action_currencyOneSelectFragment_to_mainFragment)
        }
    }
}