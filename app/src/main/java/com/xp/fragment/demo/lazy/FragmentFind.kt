package com.xp.fragment.demo.lazy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import com.xp.fragment.demo.R
import com.xp.fragment.demo.ext.BaseFragment

class FragmentFind : BaseFragment() {
    val TAG = "xf" + this.javaClass.simpleName

    override fun needLazy(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }
    /**
     * viewpager中，不论是否懒加载,这个方法一定会执行的
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_find, container, false)
        rootView = view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
    }
    /**
     * 只适用add和show，不适用viewpager嵌套fragment
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
//        if(!hidden){
//            lazyInflate()
//        }
        Log.d(TAG, "onHiddenChanged hidden=$hidden")
    }

    override fun getUserVisibleHint(): Boolean {
        Log.d(TAG, "getUserVisibleHint")
        return super.getUserVisibleHint()
    }
    /**
     * 该方法已经标注为失效，应该是有使用局限性,fragment add和show时，该函数不会执行
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
//        if (isVisibleToUser) {
//            lazyInflate()
//        }
        Log.d(TAG, "setUserVisibleHint isVisibleToUser=$isVisibleToUser")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun lazyView() {
        super.lazyView()
        Log.d(TAG, "########### lazyView ##########")
        val viewStub = rootView?.findViewById<ViewStub>(R.id.stub_find)
        viewStub?.inflate()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

}