package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.CustomSnackBar
import com.bemo.client.R
import com.bemo.client.activity.MainActivity
import com.bemo.client.recycler.CompanyRecyclerAdapter
import com.bemo.client.databinding.FragmentResultBinding
import com.bemo.client.recycler.SelectedOptionRecyclerAdapter
import com.bemo.client.vm.CompanyViewModel
import com.bemo.client.vm.Request

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val companyAdapter = CompanyRecyclerAdapter()
    private val selectedOptionAdapter = SelectedOptionRecyclerAdapter()
    private val companyViewModel = CompanyViewModel(Request.COMPANY_RESULT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val mBinding = FragmentResultBinding.inflate(inflater, container, false).apply {
            viewCompany.adapter = companyAdapter
            viewCompany.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            viewSelectedOption.adapter = selectedOptionAdapter
            viewSelectedOption.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)

            imbBack.setOnClickListener {
                (activity as MainActivity).viewHome()
            }

            txtAd.setOnClickListener {
                CustomSnackBar(root, getString(R.string.text_ad)).show()
            }
            imbSort.setOnClickListener {
                companyViewModel.addSelectedOptionItem("수학")
            }
        }

        mBinding.viewModel = companyViewModel
        mBinding.lifecycleOwner = this

        companyViewModel.companyList.observe(viewLifecycleOwner) {
            companyViewModel.companyList.value?.let { companyAdapter.setData(it) }
        }

        companyViewModel.selectedOptionList.observe(viewLifecycleOwner) {
            companyViewModel.selectedOptionList.value?.let { selectedOptionAdapter.setData(it) }
        }

        return mBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}