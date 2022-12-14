package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Company
import com.bemo.client.R
import com.bemo.client.databinding.RecyclerviewBinding
import com.bemo.client.recycler.CompanyRecyclerAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LatestFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val mList = ArrayList<Company>()
    private val mAdapter = CompanyRecyclerAdapter(mList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        addList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val mBinding = RecyclerviewBinding.inflate(inflater, container, false).apply {
            viewRecycler.adapter = mAdapter
            viewRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }

        return mBinding.root
    }

    private fun addList() {
        val start = mList.size

        // TODO: 최근 본 업체 정보 API 호출
        mList += getLatestList()
        mAdapter.notifyItemRangeInserted(start, mList.size)
    }

    private fun getLatestList(): ArrayList<Company> {
        val list = ArrayList<Company>()
        repeat(5) {
            list.add(Company(
                name = "업체 이름",
                img = R.drawable.img_place1,
                isPremium = true,
                favorite = true,
                address = "경기도 남양주시 도농동",
                target = "10대",
                distance = "1km"
            ))
        }
        list.add(Company())
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LatestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}