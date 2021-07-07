package com.xp.fragment.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.xp.fragment.demo.ext.BaseFragment

/**
 * 如果不处理返回键，直接退出app
 * 如果处理返回键，回到上一级的fragment
 */
class ThirdFragment : BaseFragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.third_fragment, container, false)
        return view
    }

    override fun onFragmentBack(): Boolean
    {
        backStack()
        Toast.makeText(activity, "第3个fragment按下返回键", Toast.LENGTH_SHORT).show()
        return true
    }

}