package com.xp.fragment.demo.lazy

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.xp.fragment.demo.R
import com.xp.fragment.demo.ext.BaseActivity

class LazyActivity2 : BaseActivity(), View.OnClickListener {
    private var btnHome: Button? = null
    private var btnFind: Button? = null
    private var btnMe: Button? = null
    val home = FragmentHome()
    val find = FragmentFind()
    val me = FragmentMe()
    val list = mutableListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy2)
        btnHome = findViewById(R.id.btn_home)
        btnFind = findViewById(R.id.btn_find)
        btnMe = findViewById(R.id.btn_me)
        btnHome?.setOnClickListener(this)
        btnFind?.setOnClickListener(this)
        btnMe?.setOnClickListener(this)

        list.add(home)
        list.add(find)
        list.add(me)
        val ft = supportFragmentManager.beginTransaction()
        list.forEach {
            ft.add(R.id.lazy_container, it)
            if (it is FragmentHome) {
                ft.show(it)
            } else {
                ft.hide(it)
            }
        }
        ft.commitAllowingStateLoss()
    }

    private fun showFragment(showFrg: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.show(showFrg)
        list.filter { it != showFrg }.forEach { ft.hide(it) }
        ft.commitAllowingStateLoss()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home -> {
                showFragment(home)
            }
            R.id.btn_find -> {
                showFragment(find)
            }
            R.id.btn_me -> {
                showFragment(me)
            }
        }
    }

}