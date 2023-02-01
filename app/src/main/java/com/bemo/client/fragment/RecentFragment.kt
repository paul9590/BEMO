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
import com.bemo.client.recycler.CompanyRecyclerAdapter
import com.bemo.client.vm.CompanyViewModel
import com.bemo.client.vm.Request

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecentFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val adapter = CompanyRecyclerAdapter()
    private val viewModel = CompanyViewModel(Request.COMPANY_RECENT)

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

            viewList.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                var stopped = false
                override fun onScrolled(recyclerView:RecyclerView, dx:Int, dy:Int) {
                    if(stopped) {
                        super.onScrolled(recyclerView, dx, dy)
                        if (dy < 0) {
                            (activity as MainActivity).showNavigationViewWithAnimation()
                        }else {
                            (activity as MainActivity).hideNavigationViewWithAnimation()
                        }
                    }
                }
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    stopped = true
                }
            })
        }

        viewModel.companyList.observe(viewLifecycleOwner) {
            viewModel.companyList.value?.let { adapter.setData(it) }
        }

        return mBinding.root
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).showNavigationView()
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