package com.xp.fragment.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.xp.fragment.demo.ext.BaseFragment

class PersonFragment : BaseFragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.person_fragment, container, false)
        val button = view.findViewById<Button>(R.id.show_second)
        button.setOnClickListener {
            val secondFragment = SecondFragment()
            val tag="secondFragment"
            childFragmentManager.beginTransaction()
                .replace(R.id.second_container, secondFragment,tag)
                .addToBackStack(tag)
                .commitAllowingStateLoss()
        }
        return view
    }

    override fun onFragmentBack(): Boolean
    {
        Toast.makeText(activity, "第一个fragment处理返回键", Toast.LENGTH_SHORT).show()
        return true
    }
}