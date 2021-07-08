package com.xp.fragment.demo.lazy

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.xp.fragment.demo.R
import com.xp.fragment.demo.ext.BaseActivity

class LazyActivity : BaseActivity() {
    private var viewpager1: ViewPager? = null
    private var btnHome: Button? = null
    private var btnFind: Button? = null
    private var btnMe: Button? = null
    private var mAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy)
        viewpager1 = findViewById(R.id.viewpager1)
        btnHome = findViewById(R.id.btn_home)
        btnFind = findViewById(R.id.btn_find)
        btnMe = findViewById(R.id.btn_me)
        val list = ArrayList<Fragment>()
        val home = FragmentHome()
        val find = FragmentFind()
        val me = FragmentMe()
        list.add(home)
        list.add(find)
        list.add(me)
        mAdapter = ViewPagerAdapter(supportFragmentManager, list)
        viewpager1?.offscreenPageLimit=1
        viewpager1?.adapter = mAdapter


    }
}