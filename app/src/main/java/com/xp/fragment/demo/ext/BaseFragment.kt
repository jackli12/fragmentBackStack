package com.xp.fragment.demo.ext

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), FragmentBackHandler {

    /**
     * 是否需要懒加载
     */
    open fun needLazy(): Boolean {
        return false
    }

    override fun onFragmentBack(): Boolean {
        return false
    }

    fun backStack() {
        parentFragmentManager.popBackStack()
    }
}