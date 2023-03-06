package com.example.currencyconvertor.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.currencyconvertor.R
import com.example.currencyconvertor.databinding.FragmentCurrencyTwoSelectBinding
import com.example.currencyconvertor.ui.BaseFragment
import com.example.currencyconvertor.ui.adapters.CurrencyTwoSelectAdapter
import com.example.currencyconvertor.ui.adapters.ListenerTwo
import com.example.currencyconvertor.ui.model.DataUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyTwoSelectFragment : BaseFragment<FragmentCurrencyTwoSelectBinding>() {

    private val vm by activityViewModels<MainFragmentViewModel>()
    private lateinit var mAdapterTwo: CurrencyTwoSelectAdapter

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentCurrencyTwoSelectBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapterTwo = CurrencyTwoSelectAdapter(object : ListenerTwo {
            override fun invoke(dataUi: DataUi.Rate) {
                vm.setCheckedCurrencyTwo(dataUi.name)
                mAdapterTwo.notifyDataSetChanged()
            }
        })

        binding.rvFragmentCurrencySelectTwo.adapter = mAdapterTwo

        vm.dataTwo.observe(viewLifecycleOwner) {
            mAdapterTwo.submitList(it.rate)
        }

        vm.dataCheckedTwo.observe(viewLifecycleOwner) {
            mAdapterTwo.submitList(it)
        }

        binding.txtCancelTwo.setOnClickListener {
            findNavController().navigate(R.id.action_currencyTwoSelectFragment_to_mainFragment)
        }
    }
}