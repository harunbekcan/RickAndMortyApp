package com.harunbekcan.rickandmortyapp.utils

fun Int?.orZero() = this ?: 0

fun <T> List<T>?.orEmptyList() = this ?: emptyList()

fun Any?.orAny() = this ?: Any()