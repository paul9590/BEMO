package com.bemo.client.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bemo.client.*
import com.bemo.client.model.Company
import kotlin.collections.ArrayList

class CompanyInfoViewModel(): ViewModel() {
    private val _infoList = MutableLiveData<ArrayList<CompanyInfo>>()
    val infoList: MutableLiveData<ArrayList<CompanyInfo>>
        get() = _infoList

    init {
        _infoList.value = getList()
    }

    // TODO: 업체 상세 정보 호출

    private fun getList(): ArrayList<CompanyInfo> {
        return ArrayList<CompanyInfo>().apply {
            add(CompanyDetail(address = "경기도 남양주시 다산동",
                            target = "10 ~ 20대",
                            distance = "120m",
                            img = R.drawable.img_lesson1))
            add(CompanyInfoTeacher())
            add(CompanyInfoReview())
            add(CompanyInfoReviewAvg())
            add(CompanyInfoCategory(ArrayList()))
        }
    }
}
