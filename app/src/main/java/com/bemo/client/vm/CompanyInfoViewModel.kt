package com.bemo.client.vm

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bemo.client.*
import kotlin.collections.ArrayList

class CompanyInfoViewModel: ViewModel() {
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
                            img = R.drawable.img_lesson1,
                            utilityList = ArrayList<Utility>().apply{
                                add(Utility("셔틀버스", R.color.yellow2, R.color.yellow))
                                add(Utility("비대면강의", R.color.green2, R.color.green))
                                add(Utility("국비지원", R.color.light_blue2, R.color.blue2))
                            }
            ))
            add(CompanyInfoTeacher())
            add(CompanyInfoReview())
            add(CompanyInfoReviewAvg())
            add(CompanyInfoCategory(ArrayList()))
        }
    }
}
