package com.ortudev.sportsResults.ui.main

sealed class Filter{
    object Ascending:Filter()
    object Descending:Filter()
}
