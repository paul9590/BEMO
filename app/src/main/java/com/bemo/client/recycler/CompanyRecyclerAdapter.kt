package com.bemo.client.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.databinding.ListCompanyBinding
import com.bemo.client.model.Company

class CompanyRecyclerAdapter : RecyclerView.Adapter<CompanyRecyclerAdapter.CompanyViewHolder>() {
    private var companyList = ArrayList<Company>()

    class CompanyViewHolder(val mBinding: ListCompanyBinding): RecyclerView.ViewHolder(mBinding.root) {
        fun bind(company: Company) {
            mBinding.company = company
            mBinding.imgCompany.setImageResource(company.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val mBinding = ListCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(companyList[position])
        holder.mBinding.root.setOnClickListener {

        }
    }

    internal fun setData(newItems: ArrayList<Company>) {
        this.companyList = newItems
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return companyList.size
    }
}