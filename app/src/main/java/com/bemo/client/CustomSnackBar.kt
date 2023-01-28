package com.bemo.client

import android.view.LayoutInflater
import android.view.View
import com.bemo.client.databinding.CustomSnackBarBinding
import com.google.android.material.snackbar.Snackbar

class CustomSnackBar(view: View, private val message: String) {

    companion object {
        fun make(view: View, message: String) = CustomSnackBar(view, message)
    }

    private val context = view.context
    private val snackBar = Snackbar.make(view, "", 5000)
    private val layout = snackBar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val mBinding: CustomSnackBarBinding = CustomSnackBarBinding.inflate(inflater)

    init {
        initView()
        initData()
    }

    private fun initView() {
        with(layout) {
            removeAllViews()
            addView(mBinding.root, 0)
        }
    }

    private fun initData() {
        mBinding.txt.text = message
    }

    fun show() {
        snackBar.show()
    }
}