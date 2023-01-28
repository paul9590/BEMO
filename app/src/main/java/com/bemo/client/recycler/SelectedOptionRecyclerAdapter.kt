package com.bemo.client.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.databinding.ListSelectedOptionBinding

class SelectedOptionRecyclerAdapter : RecyclerView.Adapter<SelectedOptionRecyclerAdapter.SelectedOptionViewHolder>() {
    private var selectedOptionList = ArrayList<String>()
    private lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedOptionViewHolder {
        view = parent
        val mBinding = ListSelectedOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectedOptionViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: SelectedOptionViewHolder, position: Int) {
        holder.bind(selectedOptionList[position])
        holder.mBinding.root.setOnClickListener {
            //TODO 선택한 옵션 삭제
            selectedOptionList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    internal fun setData(newItems: ArrayList<String>) {
        this.selectedOptionList = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return selectedOptionList.size
    }

    class SelectedOptionViewHolder(val mBinding: ListSelectedOptionBinding): RecyclerView.ViewHolder(mBinding.root) {
        fun bind(txt: String) {
            mBinding.txtSelected.text = txt
        }
    }
}