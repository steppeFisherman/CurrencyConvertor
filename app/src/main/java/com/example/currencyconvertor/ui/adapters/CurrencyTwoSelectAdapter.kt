package com.example.currencyconvertor.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconvertor.R
import com.example.currencyconvertor.databinding.ItemRawBinding
import com.example.currencyconvertor.ui.model.DataUi
import com.example.currencyconvertor.utils.visible

typealias ListenerTwo = (dataUi: DataUi.Rate) -> Unit

class CurrencyTwoSelectAdapter(private val listenerTwo: ListenerTwo) :
    ListAdapter<DataUi.Rate, CurrencyTwoSelectAdapter.MainHolder>(ItemCallback),
    View.OnClickListener {

    override fun onClick(v: View) {
        val dataUi = v.tag as DataUi.Rate
        when (v.id) {
            R.id.container -> {
                dataUi.isChecked = true
                listenerTwo(dataUi)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = ItemRawBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        view.container.setOnClickListener(this)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val item = getItem(position)

        holder.binding.apply {
            root.tag = item
            container.tag = item

            flagImg.animation = AnimationUtils
                .loadAnimation(holder.binding.root.context, R.anim.fade_transition_animation)
            txtMain.text = item.name
            txtMainShort.text = item.abbreviation
            flagImg.setImageDrawable(item.flag)

            if (item.isChecked) imgSelected.visible(true)
            else imgSelected.visible(false)
        }
    }

    class MainHolder(val binding: ItemRawBinding) : RecyclerView.ViewHolder(binding.root)

    object ItemCallback : DiffUtil.ItemCallback<DataUi.Rate>() {
        override fun areItemsTheSame(oldItem: DataUi.Rate, newItem: DataUi.Rate) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: DataUi.Rate, newItem: DataUi.Rate) =
            oldItem == newItem
    }
}