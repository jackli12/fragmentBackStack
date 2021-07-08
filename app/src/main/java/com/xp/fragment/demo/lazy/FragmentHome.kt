package com.xp.fragment.demo.lazy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Toast
import com.xp.fragment.demo.R
import com.xp.fragment.demo.ext.BaseFragment

/**
 * 1.是否需要懒加载
 * 2.是否需要重新加载ui和数据
 *
 */
class FragmentHome : BaseFragment() {
    val TAG = "xf" + this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.d(TAG, "onHiddenChanged hidden=$hidden")
    }

    override fun getUserVisibleHint(): Boolean {
        Log.d(TAG, "getUserVisibleHint")
        return super.getUserVisibleHint()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.d(TAG, "setUserVisibleHint isVisibleToUser=$isVisibleToUser")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onFragmentBack(): Boolean {
        Toast.makeText(activity, "home fragment back key", Toast.LENGTH_SHORT).show()
        return super.onFragmentBack()
    }

    override fun needLazy(): Boolean {
        return true
    }

    override fun lazyView() {
        super.lazyView()
        val stub = rootView?.findViewById<ViewStub>(R.id.stub_home)
        stub?.inflate()
    }

}