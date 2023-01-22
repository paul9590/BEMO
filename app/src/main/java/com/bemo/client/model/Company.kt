package com.bemo.client.model

import com.bemo.client.COMPANY_COMPANY
import com.bemo.client.CompanyInfo
import com.bemo.client.R
import java.io.Serializable


data class Company(
    override val name: String = "",
    val img: Int = R.drawable.img_default_company,
    val isPremium: Boolean = false,
    val isGB: Boolean = false,
    val target: String = "",
    val distance: String = "",
    val category: ArrayList<String> = ArrayList(),
    val reviewAvg: Float = 0.0f,
    val reviewCnt: Int = 0
) :
    Serializable, CompanyInfo {
    override val type = COMPANY_COMPANY
    val categoryToString: String get() {
        if(category.isEmpty()) {
            return ""
        }

        val sb = StringBuilder()
        sb.append(category[0])
        for(i in 1 until category.size) {
            sb.append(" · ").append(category[i])
        }
        return sb.toString()
    }

    val reviewToString: String get() {
        return "${reviewAvg}(${reviewCnt})"
    }
}