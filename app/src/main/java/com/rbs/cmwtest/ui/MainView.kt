package com.rbs.cmwtest.ui

import com.rbs.cmwtest.base.View

interface MainView : View {
    fun setSuccessMessage(message: String)
}