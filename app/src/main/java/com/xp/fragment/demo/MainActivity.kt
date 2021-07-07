package com.xp.fragment.demo

import android.os.Bundle
import android.widget.Button
import com.xp.fragment.demo.ext.BaseActivity

class MainActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.show_person).setOnClickListener {
            showSingleFragment()
        }
    }

    private fun showSingleFragment()
    {
        val ft = supportFragmentManager.beginTransaction()
        val personFragment = PersonFragment()
        ft.replace(R.id.frs_container, personFragment).commitAllowingStateLoss()
    }

}