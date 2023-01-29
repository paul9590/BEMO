package com.bemo.client.activity

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.bemo.client.R
import com.bemo.client.databinding.ActivityMainBinding
import com.bemo.client.fragment.HomeFragment
import com.bemo.client.fragment.MyFragment
import com.bemo.client.fragment.ResultFragment
import com.bemo.client.viewadapter.ViewAdapter
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        setTab()

        mBinding.root.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // TODO: splash 화면
                    return true
                }
            }
        )
    }

    private fun setTab() {
        val adapter = ViewAdapter(supportFragmentManager)
        adapter.apply {
            addList(HomeFragment())
            addList(ResultFragment())
            addList(MyFragment())
        }

        val texts = arrayOf("홈", "검색 결과", "마이")
        val icons = arrayOf(R.drawable.ic_home, R.drawable.ic_search, R.drawable.ic_my)

        mBinding.apply {
            pagerMain.adapter = adapter
            tabMain.setupWithViewPager(mBinding.pagerMain)

            for (i in texts.indices) {
                val tab = tabMain.getTabAt(i)!!
                tab.text = texts[i]
                tab.setIcon(icons[i])
                tab.icon?.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
            }

            tabMain.getTabAt(0)!!.icon?.setColorFilter(
                resources.getColor(R.color.black),
                PorterDuff.Mode.SRC_IN
            )
        }

        mBinding.tabMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(p0: TabLayout.Tab?) {
                mBinding.pagerMain.currentItem = p0!!.position
                p0.icon?.setColorFilter(resources.getColor(R.color.black), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                p0!!.icon?.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }
        })
    }

    fun viewHome() {
        mBinding.pagerMain.currentItem = 0
    }

    fun showNavigationView() {
        mBinding.viewMain.visibility = View.VISIBLE
    }
    fun showNavigationViewWithAnimation() {
        val animation: Animation = AlphaAnimation(0f, 1f)
        animation.duration = 200
        mBinding.viewMain.animation = animation
        mBinding.viewMain.visibility = View.VISIBLE
    }
    fun hideNavigationViewWithAnimation() {
        val animation: Animation = AlphaAnimation(1f, 0f)
        animation.duration = 200
        mBinding.viewMain.animation = animation
        mBinding.viewMain.visibility = View.GONE
    }
}
