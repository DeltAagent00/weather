package com.home.dev.weather.mvp.presenter

interface ISearchPresenter {
    fun changeTerm(term: String?)
    fun openSearch()
    fun closeSearch()
}