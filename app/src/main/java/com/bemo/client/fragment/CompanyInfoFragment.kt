package com.bemo.client.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.activity.MainActivity
import com.bemo.client.databinding.FragmentRecyclerBinding
import com.bemo.client.recycler.CompanyInfoRecyclerAdapter
import com.bemo.client.vm.CompanyInfoViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompanyInfoFragment: Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val adapter = CompanyInfoRecyclerAdapter()
    private val viewModel = CompanyInfoViewModel()

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

        val mBinding = FragmentRecyclerBinding.inflate(inflater, container, false).apply {
            viewList.adapter = adapter
            viewList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }

        viewModel.infoList.observe(viewLifecycleOwner) {
            viewModel.infoList.value?.let { adapter.setData(it) }
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