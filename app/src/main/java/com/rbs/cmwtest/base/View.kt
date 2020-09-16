package com.rbs.cmwtest.base

interface View {
    fun initializePresenter()

    fun setService()

    fun setErrorMessage(message: String)
}