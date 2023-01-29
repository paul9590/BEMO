package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bemo.client.*
import com.bemo.client.databinding.ListCompanyBinding

class CompanyInfoRecyclerAdapter(data: ArrayList<CompanyInfo>):
    RecyclerView.Adapter<CustomViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        context = parent.context
        return CustomViewHolder(ListCompanyBinding.inflate(LayoutInflater.from(context), parent, false))

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: CompanyInfo = mData[position]
        val mBinding = holder.mBinding
        bind(item, mBinding)
    }

    private fun bind(item: CompanyInfo, mBinding: ViewBinding) {

    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size
}

class CustomViewHolder(val mBinding: ViewBinding): RecyclerView.ViewHolder(mBinding.root)