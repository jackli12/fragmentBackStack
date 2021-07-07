package com.xp.fragment.demo.ext

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity()
{
//    protected var fragmentBackHandler: FragmentBackHandler? = null

    /**
     * 基类处理返回键
     */
    override fun onBackPressed()
    {
        if (!BackHandlerHelper.handleBackPress(supportFragmentManager))
        {
            super.onBackPressed()
        }
    }

}