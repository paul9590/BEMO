package com.bemo.client.vm

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
            add(CompanyInfoTeacher(name = "주진영", rank = "대표", career = "백엔드 개발자 1년\n카카오톡 입사\n안녕하세요 저는 주진영 입니다.\n" +
                    "안녕하세요 저는 주진영 입니다 반가워요\n" +
                    "안녕하세요 저는 주진영 입니다.\n",introduce = "안녕하세요 저는 주진영 입니다."))
            add(CompanyInfoReview())
            add(CompanyInfoReviewAvg())
            add(CompanyInfoCategory(ArrayList()))
        }
    }
}
