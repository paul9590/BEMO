package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.databinding.ActivityCompanyBinding
import com.bemo.client.fragment.CompanyInfoFragment
import com.bemo.client.model.Company
import com.bemo.client.viewadapter.ViewAdapter

class CompanyActivity: AppCompatActivity() {

    private val mBinding: ActivityCompanyBinding by lazy { ActivityCompanyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        val company = intent.getSerializableExtra("company") as Company

        mBinding.apply {
            txtCompanyName.text = company.name
            chkFavorite.isChecked = company.isFavorite
            //TODO: btnCall, btnMessage
            imbBack.setOnClickListener {
                finish()
            }
        }
        setTab()
    }


    private fun setTab() {
        val adapter = ViewAdapter(supportFragmentManager).apply {
            addList(CompanyInfoFragment())
            addList(CompanyInfoFragment())
            addList(CompanyInfoFragment())
            addList(CompanyInfoFragment())
            addList(CompanyInfoFragment())
        }

        mBinding.pagerCompany.adapter = adapter
        mBinding.tabCompany.setupWithViewPager(mBinding.pagerCompany)
        // TODO: 학원 정보 API 호출
        val texts = arrayOf("기본", "강사소개", "상세", "시설사진", "리뷰")

        for(i in texts.indices) {
            val tab = mBinding.tabCompany.getTabAt(i)!!
            tab.text = texts[i]
        }
    }
}