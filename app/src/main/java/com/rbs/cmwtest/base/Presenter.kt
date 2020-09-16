package com.rbs.cmwtest.base

interface Presenter <V : View> {
    fun attachView(view: V)

    fun detachView()

    fun getView(): V?
}