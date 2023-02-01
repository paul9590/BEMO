package com.bemo.client.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Category
import com.bemo.client.databinding.ListUtilBinding

class CompanyCategoryRecyclerAdapter(private val mList: ArrayList<Category>) : RecyclerView.Adapter<CompanyCategoryRecyclerAdapter.CompanyCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyCategoryViewHolder {
        val mBinding = ListUtilBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyCategoryViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: CompanyCategoryViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class CompanyCategoryViewHolder(val mBinding: ListUtilBinding): RecyclerView.ViewHolder(mBinding.root) {
        fun bind(category: Category) {
            mBinding.txtUtil.text = category.name
            //TODO Background
        }
    }
}