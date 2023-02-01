package com.bemo.client.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Utility
import com.bemo.client.databinding.ListUtilityBinding

class CompanyUtilityRecyclerAdapter(private val mList: ArrayList<Utility>) : RecyclerView.Adapter<CompanyUtilityRecyclerAdapter.CompanyUtilityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyUtilityViewHolder {
        val mBinding = ListUtilityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyUtilityViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: CompanyUtilityViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class CompanyUtilityViewHolder(val mBinding: ListUtilityBinding): RecyclerView.ViewHolder(mBinding.root) {
        fun bind(utility: Utility) {
            mBinding.txtUtility.text = utility.name
            mBinding.txtUtility.setTextColor(ContextCompat.getColor(mBinding.root.context, utility.textColor))
            mBinding.viewUtility.setCardBackgroundColor(ContextCompat.getColor(mBinding.root.context, utility.background))
        }
    }
}