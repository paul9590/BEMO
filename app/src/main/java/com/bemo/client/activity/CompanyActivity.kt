package com.bemo.client.activity

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.R
import com.bemo.client.databinding.ActivityCompanyBinding

class CompanyActivity: AppCompatActivity() {

    private val mBinding: ActivityCompanyBinding by lazy { ActivityCompanyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        val company = intent.getStringExtra("company")
        mBinding.apply {
            txtCompanyName.text = company
            imbBack.setOnClickListener {
                finish()
            }
        }
    }
}