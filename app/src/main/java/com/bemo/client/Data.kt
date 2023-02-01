package com.bemo.client

import android.content.Intent
import java.io.Serializable

const val COMPANY_INFO = 1
const val COMPANY_TEXT = 2
const val COMPANY_IMG = 3
const val COMPANY_TEACHER = 4
const val COMPANY_REVIEW_AVG = 5
const val COMPANY_REVIEW = 6
const val COMPANY_CATEGORY = 7
const val COMPANY_LOCATION = 8

interface CompanyInfo {
    val type: Int
}

data class CompanyInfoText(val title: String = "", val body: String = ""): CompanyInfo {
    override val type = COMPANY_TEXT
}

data class CompanyInfoImg(val title: String = "", val img: Int = R.drawable.img_default_company_info): CompanyInfo {
    override val type = COMPANY_IMG
}

data class CompanyInfoTeacher(val name: String = "", val desc: String = "", val img: Int = R.drawable.img_default_company_info_career, val rank: String = "", val introduce: String = ""): CompanyInfo {
    override val type = COMPANY_TEACHER
}
data class CompanyInfoReviewAvg(val title: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = COMPANY_REVIEW_AVG
}
data class CompanyInfoReview(val name: String = "", val img: Int = R.drawable.img_default_my, val body: String = "", val date: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = COMPANY_REVIEW
}

data class CompanyDetail(
    val img: Int = R.drawable.img_default_company,
    val address: String = "",
    val target: String = "",
    val distance: String = "",
    val utility: ArrayList<String> = ArrayList(),
) :
    Serializable, CompanyInfo {
    override val type = COMPANY_INFO
}

data class CompanyInfoCategory(val categoryList: ArrayList<Category> = ArrayList()): CompanyInfo {
    override val type = COMPANY_CATEGORY
}

data class CompanyInfoLocation(val img: Int = R.drawable.img_default_company_info): CompanyInfo {
    override val type = COMPANY_LOCATION
}

data class HomeCategory(val img : Int, val txt : String)

const val INTENT_LOGOUT = 1
const val INTENT_DELETE = 2

data class InfoIntent(val name: String, val intent: Intent, val flag: Int = 0)

data class Info(val title: String, val body: String)

data class PointInfo(val title: String, val body: String, val img: Int)

data class Category(val name: String, val color: Int)