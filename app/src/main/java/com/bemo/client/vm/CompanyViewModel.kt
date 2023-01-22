package com.bemo.client.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bemo.client.R
import com.bemo.client.model.Company
import kotlin.collections.ArrayList

enum class Request {
    COMPANY_RESULT, COMPANY_RECENT, COMPANY_FAVORITE
}

class CompanyViewModel(private val request: Request): ViewModel() {
    private val _companyList = MutableLiveData<ArrayList<Company>>()
    val companyList: MutableLiveData<ArrayList<Company>>
        get() = _companyList

    init {
        _companyList.value = getCompanyList()
    }

    // TODO: 최근 본 업체 정보 API 호출
    // TODO: 검색 결과 업체 정보 API 호출
    // TODO: 찜 목록 업체 정보 API 호출

    private fun getCompanyList(): ArrayList<Company> {
        return when(request) {
            Request.COMPANY_RESULT -> tmpCompanyList()
            Request.COMPANY_RECENT -> tmpCompanyList2()
            Request.COMPANY_FAVORITE -> tmpCompanyList()
        }
    }

    private fun tmpCompanyList(): ArrayList<Company> {
        return ArrayList<Company>().apply {
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
        }
    }
    private fun tmpCompanyList2(): ArrayList<Company> {
        return ArrayList<Company>().apply {
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = false, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company(name = "송수학 학원", img = R.drawable.img_place1, isPremium = true, isGB = true,  target = "10대", distance = "1km", category = arrayListOf("수학", "영어"), reviewAvg = 4.3f, reviewCnt = 10))
            add(Company())
        }
    }
}
