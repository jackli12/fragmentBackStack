package com.xp.fragment.demo.ext

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(), FragmentBackHandler
{
    override fun onFragmentBack(): Boolean
    {
        return false
    }

    fun backStack()
    {
        parentFragmentManager.popBackStack()
    }
}