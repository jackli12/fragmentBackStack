package com.xp.fragment.demo.ext

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * 多级fragment返回键处理
 */
class BackHandlerHelper
{
    companion object
    {
        fun handleBackPress(fragmentManager: FragmentManager): Boolean
        {
            val fragmentList = fragmentManager.fragments
            if (fragmentList.isEmpty()) return false //遍历全部活动状态下的fragment
            Log.d("xpandroid", "fragmentList size=${fragmentList.size}")
            fragmentList.forEach {
                return nextHandler(it) //                return if (nextHandler(it))
            }

            if (fragmentManager.backStackEntryCount > 0)
            {
                fragmentManager.popBackStack()
                return true
            }

            return false
        }
        /**
         * 递归所有活动的fragment
         */
        private fun nextHandler(it: Fragment?): Boolean
        {
            val childList = it?.childFragmentManager?.fragments
            Log.d("xpandroid", "nextHandler childList size=${childList?.size}")

            if (childList?.isEmpty() == true)
            {
                return isFragmentBackHandled(it)
            }
            childList?.forEach {
                return nextHandler(it)
            }
            return false
        }
        /**
         * true表示fragment需要消费返回键事件
         */
        private fun isFragmentBackHandled(fragment: Fragment): Boolean
        {
            return fragment.isVisible && fragment.userVisibleHint && fragment is FragmentBackHandler && fragment.onFragmentBack()
        }

    }

}