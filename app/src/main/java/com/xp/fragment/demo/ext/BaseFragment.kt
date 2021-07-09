package com.xp.fragment.demo.ext

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), FragmentBackHandler {
    var rootView: View? = null
    var callResume = false
    var mIsVisibleToUser = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView = view
    }
    /**
     * 是否需要懒加载，统一懒加载处理
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

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        mIsVisibleToUser = !hidden
        lazyInflate()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mIsVisibleToUser = isVisibleToUser
        lazyInflate()
    }

    override fun onResume() {
        super.onResume()
        callResume = true
        lazyInflate()
    }
    /**
     * 3个地方调用是未了多种问题
     * 1.初始化的fragment无法使用到懒加载模式
     * 2.add和show模式下使用懒加载
     * 3.viewpager和fragment嵌套
     */
    private fun lazyInflate() {
        Log.e("xf-baseFragment", "lazyInflate mIsVisibleToUser=$mIsVisibleToUser callResume=$callResume")
        if (needLazy() && callResume && mIsVisibleToUser) {
            lazyView()
        }
    }

    open fun lazyView() {

    }

    override fun onDestroy() {
        super.onDestroy()
//        callResume = false
//        mIsVisibleToUser=false
    }

}