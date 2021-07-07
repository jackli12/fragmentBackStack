package com.xp.fragment.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.xp.fragment.demo.ext.BaseFragment

/**
 * 如果不处理返回键，直接退出app
 * 如果处理返回键，回到上一级的fragment
 */
class SecondFragment : BaseFragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        val button = view.findViewById<Button>(R.id.show_frg2)
        button.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val tag = "thirdFragment"
            childFragmentManager.beginTransaction().replace(R.id.third_container, thirdFragment, tag).addToBackStack(tag).commitAllowingStateLoss()
        }
        return view
    }

    override fun onFragmentBack(): Boolean
    {
        backStack()
        Toast.makeText(activity, "第二个fragment按下返回键", Toast.LENGTH_SHORT).show()
        return true
    }

}