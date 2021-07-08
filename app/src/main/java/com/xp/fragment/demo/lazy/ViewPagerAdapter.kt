package com.xp.fragment.demo.lazy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager, frgList: ArrayList<Fragment>) : FragmentStatePagerAdapter(fm) {
    var frgList: ArrayList<Fragment>? = null

    init {
        this.frgList = frgList
    }

    override fun getCount(): Int {
        return frgList?.size ?: 0
    }

    override fun getItem(position: Int): Fragment {
        return frgList?.get(position) ?: FragmentFind()
    }

}