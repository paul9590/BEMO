package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bemo.client.*
import com.bemo.client.databinding.ListCategoryBinding
import com.bemo.client.databinding.ListCompanyCategoryBinding
import com.bemo.client.databinding.ListCompanyImgBinding
import com.bemo.client.databinding.ListCompanyInfoBinding
import com.bemo.client.databinding.ListCompanyLocationBinding
import com.bemo.client.databinding.ListCompanyReviewAvgBinding
import com.bemo.client.databinding.ListCompanyReviewBinding
import com.bemo.client.databinding.ListCompanyTeacherBinding
import com.bemo.client.databinding.ListCompanyTextBinding
import java.text.DecimalFormat

class CompanyInfoRecyclerAdapter():
    RecyclerView.Adapter<CustomViewHolder>(){
    private var companyInfoList = ArrayList<CompanyInfo>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        context = parent.context
        return when(viewType) {
            COMPANY_INFO -> CustomViewHolder(ListCompanyInfoBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_TEXT -> CustomViewHolder(ListCompanyTextBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_IMG -> CustomViewHolder(ListCompanyImgBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_TEACHER -> CustomViewHolder(ListCompanyTeacherBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_REVIEW_AVG -> CustomViewHolder(ListCompanyReviewAvgBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_REVIEW -> CustomViewHolder(ListCompanyReviewBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_CATEGORY -> CustomViewHolder(ListCompanyCategoryBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_LOCATION -> CustomViewHolder(ListCompanyLocationBinding.inflate(LayoutInflater.from(context), parent, false))
            else -> throw java.lang.RuntimeException("View Loading Error")
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: CompanyInfo = companyInfoList[position]
        val mBinding = holder.mBinding
        bind(item, mBinding)
    }

    private fun bind(item: CompanyInfo, mBinding: ViewBinding) {
        when(item.type) {
            COMPANY_INFO -> {
                item as CompanyDetail
                (mBinding as ListCompanyInfoBinding).apply {
                    imgCompany.setImageResource(item.img)
                    txtAddress.text = item.address
                    txtDistance.text = item.distance
                    txtTarget.text = item.target
                    viewUtility.adapter = CompanyUtilityRecyclerAdapter(item.utilityList)
                    viewUtility.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    //TODO: viewUtil
                }
            }
            COMPANY_TEXT -> {
                item as CompanyInfoText
                (mBinding as ListCompanyTextBinding).apply {
                    txtTitle.text = item.title
                    txtBody.text = item.body
                }
            }
            COMPANY_IMG -> {
                item as CompanyInfoImg
                (mBinding as ListCompanyImgBinding).apply {
                    txtTitle.text = item.title
                    imgBody.setImageResource(item.img)
                }
            }
            COMPANY_TEACHER -> {
                item as CompanyInfoTeacher
                (mBinding as ListCompanyTeacherBinding).apply {
                    txtTeacherName.text = item.name
                    imgTeacher.setImageResource(item.img)
                    txtTeacherRank.text = item.rank
                    txtTeacherIntroduce.text = item.introduce
                    txtTeacherCareer.text = item.desc
                }
            }
            COMPANY_REVIEW_AVG -> {
                item as CompanyInfoReviewAvg
                (mBinding as ListCompanyReviewAvgBinding).apply {
                    txtReviewAvg.text = item.title
                    txtReviewRating.text = DecimalFormat("#.##").format(item.rating).toString()
                }
            }
            COMPANY_REVIEW -> {
                item as CompanyInfoReview
                (mBinding as ListCompanyReviewBinding).apply {
                    txtName.text = item.name
                    txtBody.text = item.body
                    txtDate.text = item.date
                }
            }
            COMPANY_CATEGORY -> {
                item as CompanyInfoCategory
                (mBinding as ListCompanyCategoryBinding).apply {
                    viewCategory.adapter = CompanyCategoryRecyclerAdapter(item.categoryList)
                    viewCategory.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                }
            }
            COMPANY_LOCATION -> {
                item as CompanyInfoLocation
                (mBinding as ListCompanyLocationBinding).apply {
                }
            }
        }
    }

    internal fun setData(newItems: ArrayList<CompanyInfo>) {
        this.companyInfoList = newItems
        notifyDataSetChanged()
    }

    override fun getItemViewType(p: Int): Int = companyInfoList[p].type

    override fun getItemCount(): Int = companyInfoList.size
}

class CustomViewHolder(val mBinding: ViewBinding): RecyclerView.ViewHolder(mBinding.root)